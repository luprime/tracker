package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.dto.RegionPokemonDTO;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.service.RegionPokemonService;

@RestController
@RequestMapping("/region-pokemons")
public class RegionPokemonController {

    private final RegionPokemonService service;

    public RegionPokemonController(RegionPokemonService service) {
        this.service = service;
    }

    @PostMapping
    public RegionPokemon create(@RequestBody RegionPokemon rp) {
        return service.create(rp);
    }

    @GetMapping
    public List<RegionPokemon> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<RegionPokemonDTO> search(
        @RequestParam(required = false) String pokemon,
        @RequestParam(required = false) String region
    ){
        return service.search(pokemon, region);
    }
}