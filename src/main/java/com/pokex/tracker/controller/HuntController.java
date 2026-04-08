package com.pokex.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pokex.tracker.model.Hunt;
import com.pokex.tracker.repository.HuntRepository;
import com.pokex.tracker.service.HuntService;

@RestController
@RequestMapping("/hunts")
public class HuntController {

    private final HuntRepository repository;
    private final HuntService huntService;

    public HuntController(HuntRepository repository, HuntService huntService) {
        this.repository = repository;
        this.huntService = huntService;
    }

    @PostMapping
    public Hunt create(@RequestBody Hunt hunt) {
        return huntService.create(hunt);
    }

    @GetMapping
    public List<Hunt> getAll() {
        return repository.findAll();
    }
}