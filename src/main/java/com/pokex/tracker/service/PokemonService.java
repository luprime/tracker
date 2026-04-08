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

    public Pokemon create(Pokemon pokemon) {

        if (pokemon.getName() == null || pokemon.getName().isBlank()) {
            throw new RuntimeException("Nome do pokemon é obrigatório");
        }

        // 🔥 valida duplicado
        if (repository.existsByNameIgnoreCase(pokemon.getName())) {
            throw new RuntimeException("Pokemon já existe");
        }

        return repository.save(pokemon);
    }

    public List<Pokemon> getAll() {
        return repository.findAll();
    }
}