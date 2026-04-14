package com.pokex.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pokex.tracker.model.RegionPokemon;
import java.util.List;


public interface RegionPokemonRepository extends JpaRepository<RegionPokemon, Long> {

    // equivalente a: SELECT * FROM region_pokemon WHERE region_id = ?, o Spring Data JPA entende o findByRegionId e transforma sem eu ter q escrever
    List<RegionPokemon> findByRegionId(Long regionId);
    

    List<RegionPokemon> findByPokemonId(Long pokmeonId);

    boolean existsByPokemonIdAndRegionId(Long pokemonId, Long regionId);

    List<RegionPokemon> findByPokemonNameIgnoreCase(String name);

    List<RegionPokemon> findByRegionNameIgnoreCase(String name);

    List<RegionPokemon> findByPokemonNameIgnoreCaseAndRegionNameIgnoreCase(String pokemon, String region);

    boolean existsByPokemonIdAndRegionIdAndShiny(Long pokemonId, Long regionId, Boolean shiny);

}