package com.pokex.tracker.controller.admin;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.dto.CreatePokemonWithRegionsRequest;
import com.pokex.tracker.dto.RegionPokemonDTO;
import com.pokex.tracker.model.RegionPokemon;
import com.pokex.tracker.service.RegionPokemonService;

@RestController
@RequestMapping("/region-pokemons")
public class RegionPokemonController {

    private final RegionPokemonService service;

    public RegionPokemonController(RegionPokemonService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegionPokemon> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<RegionPokemonDTO> search(
        @RequestParam(required = false) String pokemon,
        @RequestParam(required = false) String region
    ){
        return service.search(pokemon, region);
    }

    @PostMapping("/simple")
    public String createSimple(
        @RequestParam String pokemonName, 
        @RequestParam String region, 
        @RequestParam Integer level,
        @RequestParam(required = false) Boolean shiny)
    {
        CreatePokemonWithRegionsRequest dto = new CreatePokemonWithRegionsRequest();
        dto.setPokemonName(pokemonName);
        dto.setRegion(region); // ⚠️ IMPORTANTE
        dto.setLevel(level);
        dto.setShiny(shiny);

        service.createSingle(dto);
        

    return "Criado com sucesso";
    }
}