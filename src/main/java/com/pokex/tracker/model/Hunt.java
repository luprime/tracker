package com.pokex.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RegionPokemon regionPokemon;

    @ManyToOne
    private GameCharacter character;

    private Integer duration; //colocar o tipo da classe como Integer, pq se for algum primitivo (int, double) e ele tentar colocar null, dará erro 400
    private Double loot; //aqui mesma coisa, double não roda, Double roda se for null
}