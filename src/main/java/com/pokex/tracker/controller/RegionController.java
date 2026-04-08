package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.model.Region;
import com.pokex.tracker.repository.RegionRepository;

@RestController
@RequestMapping("/regions")
public class RegionController {
    
    private final RegionRepository repository;

    public RegionController(RegionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Region create(@RequestBody Region region){
        return repository.save(region);
    }

    @GetMapping
    public List<Region> getAll() {
        return repository.findAll();
    }
}
