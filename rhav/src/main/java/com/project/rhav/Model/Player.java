package com.project.rhav.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_jogador;
    private String nacionalidade_jogador;
    private int idade_jogador;
    private double altura_jogador;
    private double peso_jogador;
    private String time_jogador;
    private int num_camisa;

}
