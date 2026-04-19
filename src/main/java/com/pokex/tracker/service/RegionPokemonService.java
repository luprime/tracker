package com.pokex.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokex.tracker.dto.CreatePokemonWithRegionsRequest;
import com.pokex.tracker.dto.RegionPokemonDTO;
import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.model.PokemonVariant;
import com.pokex.tracker.model.Region;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.repository.PokemonRepository;
import com.pokex.tracker.repository.RegionPokemonRepository;
import com.pokex.tracker.repository.RegionRepository;

@Service
public class RegionPokemonService {

    private final RegionPokemonRepository repository;
    private final PokemonRepository pokemonRepository;
    private final RegionRepository regionRepository;

    public RegionPokemonService(
        RegionPokemonRepository repository,
        PokemonRepository pokemonRepository,
        RegionRepository regionRepository
    ) {
        this.repository = repository;
        this.pokemonRepository = pokemonRepository;
        this.regionRepository = regionRepository;
    }

    public RegionPokemon create(RegionPokemon rp) {

        if (rp.getPokemon() == null || rp.getPokemon().getId() == null) {
            throw new RuntimeException("Pokemon obrigatório");
        }

        if (rp.getRegion() == null || rp.getRegion().getId() == null) {
            throw new RuntimeException("Região obrigatória");
        }

        Long pokemonId = rp.getPokemon().getId();
        Long regionId = rp.getRegion().getId();

        Pokemon pokemon = pokemonRepository.findById(pokemonId)
            .orElseThrow(() -> new RuntimeException("Pokemon não encontrado"));

        Region region = regionRepository.findById(regionId)
            .orElseThrow(() -> new RuntimeException("Região não encontrada"));

        // 🔥 VALIDAÇÃO DE DUPLICADO (CRÍTICA)
        if (repository.existsByPokemonIdAndRegionId(pokemonId, regionId)) {
            throw new RuntimeException("Esse pokemon já existe nessa região");
        }

        rp.setPokemon(pokemon);
        rp.setRegion(region);

        return repository.save(rp);
    }

    public List<RegionPokemon> getAll() {
        return repository.findAll();
    }

    public List<RegionPokemonDTO> search(String pokemon, String region) {

    List<RegionPokemon> result;

    if (pokemon != null && region != null) {
        result = repository.findByPokemonNameIgnoreCaseAndRegionNameIgnoreCase(pokemon, region);
    } else if (pokemon != null) {
        result = repository.findByPokemonNameIgnoreCase(pokemon);
    } else if (region != null) {
        result = repository.findByRegionNameIgnoreCase(region);
    } else {
        throw new RuntimeException("Informe pokemon ou region");
    }

    return result.stream()
        .map(rp -> new RegionPokemonDTO(
            rp.getPokemon().getName(),
            rp.getRegion().getName(),
            rp.getLevel(),
            rp.getVariant()
        ))
        .toList();
    }

    public void createSingle(CreatePokemonWithRegionsRequest dto) {

    // 🔹 Busca ou cria Pokémon
    String name = dto.getPokemonName().trim();

    Pokemon pokemon = pokemonRepository
        .findByNameIgnoreCase(name)
        .orElseGet(() -> {
            Pokemon p = new Pokemon();
            p.setName(name);
            return pokemonRepository.save(p);
    });

    // 🔥 REGRA IMPORTANTE (VALIDAÇÃO DE REGIÃO)
    Region region = regionRepository
        .findByNameIgnoreCase(dto.getRegion())
        .orElseThrow(() -> new RuntimeException("Região inválida: " + dto.getRegion()));


   PokemonVariant variant = dto.getVariant() != null ? dto.getVariant() : PokemonVariant.NORMAL;

    if (repository.existsByPokemonIdAndRegionIdAndVariant(pokemon.getId(), region.getId(), variant)) {
        throw new RuntimeException("Esse pokemon já existe nessa região");
    }



    RegionPokemon rp = new RegionPokemon();
    rp.setPokemon(pokemon);
    rp.setRegion(region);
    rp.setLevel(dto.getLevel());
    rp.setVariant(variant);

    repository.save(rp);
}
}
