package br.com.heinz.seucanteiro.model;

import br.com.heinz.seucanteiro.dto.PlantaFormDTO;
import br.com.heinz.seucanteiro.dto.PlantioFormDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantaPlantio {

    private PlantaFormDTO planta;
    private PlantioFormDTO plantio;
    
    
}


