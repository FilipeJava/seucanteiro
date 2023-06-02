package br.com.heinz.seucanteiro.dto.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Positive
    private Integer quantidadePlantada;

    @NotNull
    private LocalDate dataPlantio;

    private LocalDate dataColheita;

}