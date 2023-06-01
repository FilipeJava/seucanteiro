package br.com.heinz.seucanteiro.model;

import br.com.heinz.seucanteiro.dto.form.PlantaFormDTO;
import br.com.heinz.seucanteiro.dto.form.PlantioFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantaRespostaDTO;
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


