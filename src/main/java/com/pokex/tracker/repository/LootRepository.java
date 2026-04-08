package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokex.tracker.model.Loot;

public interface LootRepository extends JpaRepository<Loot, Long> {
}
