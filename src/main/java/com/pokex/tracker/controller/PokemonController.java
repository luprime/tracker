package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.repository.PokemonRepository;


@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    
    private final PokemonRepository repository;

    public PokemonController(PokemonRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return repository.findAll();
    }
}
