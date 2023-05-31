package br.com.heinz.seucanteiro.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantioFormDTO {

    @NotNull
    private Integer quantidadePlantada;

    @NotNull
    private LocalDate dataPlantio;

    private LocalDate dataColheita;

}