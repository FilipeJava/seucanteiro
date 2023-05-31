package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.dto.PlantaRespostaDTO;

import br.com.heinz.seucanteiro.model.PlantaPlantio;

public interface PlantaPlantioService {


    PlantaRespostaDTO salvar(Long idCanteiro, PlantaPlantio plantaPlantio);

    PlantaRespostaDTO autaliza(  Long idPlanta , PlantaPlantio plantaPlantio);

    PlantaPlantio buscaId(Long idPlanta);

    
}