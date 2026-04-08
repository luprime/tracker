package com.pokex.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokex.tracker.model.Region;
import com.pokex.tracker.repository.RegionRepository;

@Service
public class RegionService {

    private final RegionRepository repository;

    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }

    public Region create(Region region) {

        if (region.getName() == null || region.getName().isBlank()) {
            throw new RuntimeException("Nome da região é obrigatório");
        }

        if (repository.existsByNameIgnoreCase(region.getName())) {
            throw new RuntimeException("Região já existe");
        }

        return repository.save(region);
    }

    public List<Region> getAll() {
        return repository.findAll();
    }
}