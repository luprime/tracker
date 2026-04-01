package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.model.GameCharacter;
import com.pokex.tracker.model.Hunt;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.repository.GameCharacterRepository;
import com.pokex.tracker.repository.HuntRepository;
import com.pokex.tracker.repository.RegionPokemonRepository;

@RestController
@RequestMapping("/hunts")
public class HuntController {

    private final HuntRepository repository;
    private final RegionPokemonRepository regionPokemonRepository;
    private final GameCharacterRepository characterRepository;

    public HuntController(
            HuntRepository repository,
            RegionPokemonRepository regionPokemonRepository,
            GameCharacterRepository characterRepository) {

        this.repository = repository;
        this.regionPokemonRepository = regionPokemonRepository;
        this.characterRepository = characterRepository;
    }

    @PostMapping
    public Hunt create(@RequestBody Hunt hunt){

        Long rpId = hunt.getRegionPokemon().getId();
        Long charId = hunt.getCharacter().getId();

        RegionPokemon rp = regionPokemonRepository.findById(rpId)
            .orElseThrow(() -> new RuntimeException("RegionPokemon não encontrado"));

        GameCharacter character = characterRepository.findById(charId)
            .orElseThrow(() -> new RuntimeException("Character não encontrado"));

        hunt.setRegionPokemon(rp);
        hunt.setCharacter(character);

        return repository.save(hunt);
    }

    @GetMapping
    public List<Hunt> getAll() {
        return repository.findAll();
    }
}