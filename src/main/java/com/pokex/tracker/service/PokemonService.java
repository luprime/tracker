package com.pokex.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public Pokemon save(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    public List<Pokemon> findAll() {
        return repository.findAll();
    }
    
}
