package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    
    private final PokemonService service;

    public PokemonController(PokemonService service){
        this.service = service;
    }

    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return service.save(pokemon);
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return service.findAll();
    }
}
