package com.project.rhav.Controller;

import com.project.rhav.Model.Player;
import com.project.rhav.Repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository){
        this.repository = repository;
    }


    @GetMapping
    public String listar(Model model){
        model.addAttribute("players", repository.findAll());
        return "players";
    }


    @GetMapping("/new")
    public String novo(Model model) {
        model.addAttribute("player", new Player());
        return "player-form"; // abre player-form.html
    }


    @PostMapping
    public String salvar(@ModelAttribute Player player){
        repository.save(player);
        return "redirect:/player";
    }


    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Player existente = repository.findById(id).orElseThrow();
        model.addAttribute("player", existente);
        return "player-form";
    }


    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/player";
    }
}
