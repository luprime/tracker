package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokex.tracker.model.Hunt;

public interface HuntRepository extends JpaRepository<Hunt, Long>{

    
} 