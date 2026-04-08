package com.pokex.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokex.tracker.model.Loot;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.repository.LootRepository;
import com.pokex.tracker.repository.RegionPokemonRepository;

@Service
public class LootService {

    private final LootRepository lootRepository;
    private final RegionPokemonRepository regionPokemonRepository;

    public LootService(LootRepository lootRepository, RegionPokemonRepository regionPokemonRepository) {
        this.lootRepository = lootRepository;
        this.regionPokemonRepository = regionPokemonRepository;
    }

    public Loot create(Loot loot) {

        
        if (loot.getRegionPokemon() == null || loot.getRegionPokemon().getId() == null) {
            throw new RuntimeException("RegionPokemon obrigatório");
        }

        RegionPokemon rp = regionPokemonRepository.findById(loot.getRegionPokemon().getId())
            .orElseThrow(() -> new RuntimeException("RegionPokemon não encontrado"));

        loot.setRegionPokemon(rp);

        return lootRepository.save(loot);
    }

    public List<Loot> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    
}