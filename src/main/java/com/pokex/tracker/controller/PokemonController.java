package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokex.tracker.model.Pokemon;
import com.pokex.tracker.service.PokemonService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return service.create(pokemon);
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return service.getAll();
    }


}
