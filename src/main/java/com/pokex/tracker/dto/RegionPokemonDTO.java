package com.pokex.tracker.dto;

import com.pokex.tracker.model.PokemonVariant;

public class RegionPokemonDTO {

    private String pokemon;
    private String region;
    private Integer level;
    private PokemonVariant variant;

    public RegionPokemonDTO(String pokemon, String region, Integer level, PokemonVariant variant) {
        this.pokemon = pokemon;
        this.region = region;
        this.level = level;
        this.variant = variant;
    }

    public String getPokemon() { return pokemon; }
    public String getRegion() { return region; }
    public Integer getLevel() { return level; }
    public PokemonVariant getVariant() { return variant; }
}