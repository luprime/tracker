package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokex.tracker.model.Pokemon;

public interface UserRepository extends JpaRepository<Pokemon, Long> {
    
}