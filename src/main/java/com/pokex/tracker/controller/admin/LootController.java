package com.pokex.tracker.controller.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokex.tracker.model.Loot;
import com.pokex.tracker.service.LootService;

import org.springframework.web.bind.annotation.RequestBody; 

@RestController
@RequestMapping("/loots")
public class LootController {

    private final LootService service;

    public LootController(LootService service) {
        this.service = service;
    }

    @PostMapping
    public Loot create(@RequestBody Loot loot) {
        return service.create(loot);
    }

    
}
