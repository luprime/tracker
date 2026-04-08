package com.pokex.tracker.dto;

public class RegionPokemonDTO {

    private String pokemon;
    private String region;
    private Integer level;

    public RegionPokemonDTO(String pokemon, String region, Integer level) {
        this.pokemon = pokemon;
        this.region = region;
        this.level = level;
    }

    public String getPokemon() { return pokemon; }
    public String getRegion() { return region; }
    public Integer getLevel() { return level; }
}