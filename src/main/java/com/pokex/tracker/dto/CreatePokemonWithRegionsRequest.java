package com.pokex.tracker.dto;


import com.pokex.tracker.model.PokemonVariant;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePokemonWithRegionsRequest {

    @Schema(description = "Nome do Pokémon", example = "Shiftry")
    @NotBlank(message = "Nome do pokémon obrigatório")
    private String pokemonName;

    @Schema(description = "Lista de regiões onde o pokémon aparece", example = "Kanto")
    @NotBlank(message = "Informe ao menos uma região")
    private String region;

    @Schema(description = "Level do Pokémon na região", example = "120")
    @NotNull(message = "Level Obrigatório")
    private Integer level;

    private PokemonVariant variant;
   
}