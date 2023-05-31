package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.model.PlantaPlantio;
import br.com.heinz.seucanteiro.model.PlantaRespostaDTO;

public interface PlantaPlantioService {


    PlantaRespostaDTO salvar(Long idCanteiro, PlantaPlantio plantaPlantio);
    
}