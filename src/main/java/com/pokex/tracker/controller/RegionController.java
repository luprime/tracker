package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.model.Region;
import com.pokex.tracker.service.RegionService;

@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService service;

    public RegionController(RegionService service) {
        this.service = service;
    }

    @PostMapping
    public Region create(@RequestBody Region region) {
        return service.create(region);
    }

    @GetMapping
    public List<Region> getAll() {
        return service.getAll();
    }
}
