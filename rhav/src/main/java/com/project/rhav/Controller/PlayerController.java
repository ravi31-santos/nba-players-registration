package com.project.rhav.Controller;

import com.project.rhav.Model.Player;
import com.project.rhav.Repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository){
        this.repository=repository;
    }
    @GetMapping
    public List<Player> listar(){
        return repository.findAll();
    }
    @PostMapping
    public Player criar(@RequestBody Player player){
        return repository.save(player);
    }
    @PutMapping("/{id}")
    public Player atualizar(@PathVariable Long id,@RequestBody Player player){
        Player existente = repository.findById(id).orElseThrow();
        existente.setNome_jogador(player.getNome_jogador());
        existente.setNacionalidade_jogador(player.getNacionalidade_jogador());
        existente.setAltura_jogador(player.getAltura_jogador());
        existente.setNum_camisa(player.getNum_camisa());
        existente.setTime_jogador(player.getTime_jogador());
        existente.setPeso_jogador(player.getPeso_jogador());
        return repository.save(existente);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

}
