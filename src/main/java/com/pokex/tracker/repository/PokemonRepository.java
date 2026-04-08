package com.pokex.tracker.repository;

import com.pokex.tracker.model.Pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

    boolean existsByNameIgnoreCase(String name);

    Optional<Pokemon> findByNameIgnoreCase(String name);
} 
