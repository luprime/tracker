package com.pokex.tracker.service;

import org.springframework.stereotype.Service;

import com.pokex.tracker.dto.CreatePokemonWithRegionsRequest;
import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.model.Region;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.repository.PokemonRepository;
import com.pokex.tracker.repository.RegionPokemonRepository;
import com.pokex.tracker.repository.RegionRepository;

@Service
public class PokemonRegionService {

    private final PokemonRepository pokemonRepository;
    private final RegionRepository regionRepository;
    private final RegionPokemonRepository regionPokemonRepository;

    public PokemonRegionService(
        PokemonRepository pokemonRepository,
        RegionRepository regionRepository,
        RegionPokemonRepository regionPokemonRepository
    ) {
        this.pokemonRepository = pokemonRepository;
        this.regionRepository = regionRepository;
        this.regionPokemonRepository = regionPokemonRepository;
    }

    public void create(CreatePokemonWithRegionsRequest request) {

        // validação básica
        if (request.getPokemonName() == null || request.getPokemonName().isBlank()) {
            throw new RuntimeException("Nome do pokemon obrigatório");
        }

        if (request.getRegions() == null || request.getRegions().isEmpty()) {
            throw new RuntimeException("Lista de regiões obrigatória");
        }

        // busca ou cria pokemon
        Pokemon pokemon = pokemonRepository
            .findByNameIgnoreCase(request.getPokemonName())
            .orElseGet(() -> {
                Pokemon p = new Pokemon();
                p.setName(request.getPokemonName());
                return pokemonRepository.save(p);
            });

        // loop nas regiões
        for (String regionName : request.getRegions()) {

            Region region = regionRepository
                .findByNameIgnoreCase(regionName)
                .orElseGet(() -> {
                    Region r = new Region();
                    r.setName(regionName);
                    return regionRepository.save(r);
                });

            // evita duplicado
            boolean exists = regionPokemonRepository
                .existsByPokemonAndRegion(pokemon, region);

            if (!exists) {
                RegionPokemon rp = new RegionPokemon();
                rp.setPokemon(pokemon);
                rp.setRegion(region);
                rp.setLevel(50); 

                regionPokemonRepository.save(rp);
            }
        }
    }
}