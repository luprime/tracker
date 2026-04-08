package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.model.Region;
import com.pokex.tracker.repository.RegionPokemonRepository;
import com.pokex.tracker.repository.PokemonRepository;
import com.pokex.tracker.repository.RegionRepository;

@RestController
@RequestMapping("/region-pokemons")
public class RegionPokemonController {

    private final RegionPokemonRepository repository;
    private final PokemonRepository pokemonRepository;
    private final RegionRepository regionRepository;

    public RegionPokemonController(
        RegionPokemonRepository repository,
        PokemonRepository pokemonRepository,
        RegionRepository regionRepository
    ) {
        this.repository = repository;
        this.pokemonRepository = pokemonRepository;
        this.regionRepository = regionRepository;
    }

    @PostMapping
    public RegionPokemon create(@RequestBody RegionPokemon rp) {

        Long pokemonId = rp.getPokemon().getId();
        Long regionId = rp.getRegion().getId();

        Pokemon pokemon = pokemonRepository.findById(pokemonId)
            .orElseThrow(() -> new RuntimeException("Pokemon não encontrado"));

        Region region = regionRepository.findById(regionId)
            .orElseThrow(() -> new RuntimeException("Região não encontrada"));

        rp.setPokemon(pokemon);
        rp.setRegion(region);

        return repository.save(rp);
    }

    @GetMapping
    public List<RegionPokemon> getAll() {
        return repository.findAll();
    }
}