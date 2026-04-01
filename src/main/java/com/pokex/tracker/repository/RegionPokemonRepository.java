package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokex.tracker.model.RegionPokemon;

public interface RegionPokemonRepository extends JpaRepository<RegionPokemon, Long> {
}