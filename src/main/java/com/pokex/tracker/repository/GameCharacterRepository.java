package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokex.tracker.model.GameCharacter;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {

}