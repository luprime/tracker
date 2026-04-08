package com.pokex.tracker.dto;

import java.util.List;

public class CreatePokemonWithRegionsRequest {

    private String pokemonName;
    private List<String> regions;

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}