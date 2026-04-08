package com.pokex.tracker.controller;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.dto.CreatePokemonWithRegionsRequest;
import com.pokex.tracker.service.PokemonRegionService;

@RestController
@RequestMapping("/pokemon-regions")
public class PokemonRegionController {

    private final PokemonRegionService service;

    public PokemonRegionController(PokemonRegionService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody CreatePokemonWithRegionsRequest request) {
        service.create(request);
    }
}