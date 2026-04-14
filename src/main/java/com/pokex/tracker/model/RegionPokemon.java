package com.pokex.tracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pokemon pokemon;

    @ManyToOne
    private Region region;

    private Integer level;

    private Boolean shiny = false;
}