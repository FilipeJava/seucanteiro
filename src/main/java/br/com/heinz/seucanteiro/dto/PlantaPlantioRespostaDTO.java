package br.com.heinz.seucanteiro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantaPlantioRespostaDTO {

    private PlantaRespostaDTO planta;
    private PlantioRespostaDTO plantio;


}