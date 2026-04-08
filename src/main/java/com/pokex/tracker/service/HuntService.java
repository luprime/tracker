package com.pokex.tracker.service;

import org.springframework.stereotype.Service;

import com.pokex.tracker.model.GameCharacter;
import com.pokex.tracker.model.Hunt;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.repository.GameCharacterRepository;
import com.pokex.tracker.repository.HuntRepository;
import com.pokex.tracker.repository.RegionPokemonRepository;

@Service
public class HuntService {

    private final HuntRepository huntRepository;
    private final RegionPokemonRepository regionPokemonRepository;
    private final GameCharacterRepository characterRepository;

    public HuntService(
        HuntRepository huntRepository,
        RegionPokemonRepository regionPokemonRepository,
        GameCharacterRepository characterRepository
    ) {
        this.huntRepository = huntRepository;
        this.regionPokemonRepository = regionPokemonRepository;
        this.characterRepository = characterRepository;
    }

    public Hunt create(Hunt hunt) {

        // 🔥 VALIDAÇÕES (evita erro 400)
        if (hunt.getRegionPokemon() == null || hunt.getRegionPokemon().getId() == null) {
            throw new RuntimeException("RegionPokemon obrigatório");
        }

        if (hunt.getCharacter() == null || hunt.getCharacter().getId() == null) {
            throw new RuntimeException("Character obrigatório");
        }

        // 🔍 Busca no banco
        RegionPokemon rp = regionPokemonRepository.findById(hunt.getRegionPokemon().getId())
            .orElseThrow(() -> new RuntimeException("RegionPokemon não encontrado"));

        GameCharacter character = characterRepository.findById(hunt.getCharacter().getId())
            .orElseThrow(() -> new RuntimeException("Character não encontrado"));

        // 🔗 Seta objetos completos
        hunt.setRegionPokemon(rp);
        hunt.setCharacter(character);

        return huntRepository.save(hunt);
    }
}