package com.pokex.tracker.dto;

public class RegionPokemonDTO {

    private String pokemon;
    private String region;
    private Integer level;
    private Boolean shiny;

    public RegionPokemonDTO(String pokemon, String region, Integer level, Boolean shiny) {
        this.pokemon = pokemon;
        this.region = region;
        this.level = level;
        this.shiny = shiny;
    }

    public String getPokemon() { return pokemon; }
    public String getRegion() { return region; }
    public Integer getLevel() { return level; }
    public Boolean getShiny() { return shiny; }
}