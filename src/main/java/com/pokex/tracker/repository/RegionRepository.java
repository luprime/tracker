package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokex.tracker.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

    boolean existsByNameIgnoreCase(String name);
}
