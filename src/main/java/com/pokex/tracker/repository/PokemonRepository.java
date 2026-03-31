package com.pokex.tracker.repository;

import com.pokex.tracker.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

    
} 
