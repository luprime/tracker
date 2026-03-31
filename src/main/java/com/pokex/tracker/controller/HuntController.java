package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokex.tracker.model.Hunt;
import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.repository.HuntRepository;
import com.pokex.tracker.repository.PokemonRepository;

@RestController
@RequestMapping("/hunts")
public class HuntController {

    private final PokemonRepository pokemonRepository;

    private final HuntRepository repository;

    public HuntController(HuntRepository repository, PokemonRepository pokemonRepository){
        this.repository = repository;
        this.pokemonRepository = pokemonRepository;
    }

    @PostMapping
    public Hunt create(@RequestBody Hunt hunt){

        Long pokmeonId = hunt.getPokemon().getId();

        Pokemon pokemon = pokemonRepository.findById(pokmeonId).orElseThrow(() -> new RuntimeException("Pokemon não encontrado"));

        hunt.setPokemon(pokemon);

        return repository.save(hunt);
    }

    @GetMapping
    public List<Hunt> getAll() {
        return repository.findAll();
    }
    
}
