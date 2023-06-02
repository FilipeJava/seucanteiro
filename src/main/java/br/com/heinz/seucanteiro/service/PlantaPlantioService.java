package br.com.heinz.seucanteiro.service;

import java.util.List;

import br.com.heinz.seucanteiro.dto.resposta.PlantaPlantioRespostaDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantaRespostaDTO;
import br.com.heinz.seucanteiro.model.PlantaPlantio;

public interface PlantaPlantioService {


    PlantaRespostaDTO salvar(Long idCanteiro, PlantaPlantio plantaPlantio);

    PlantaRespostaDTO autaliza(  Long idPlanta , PlantaPlantio plantaPlantio);

    PlantaPlantioRespostaDTO buscaId(Long idPlanta);

    List<PlantaPlantioRespostaDTO> buscaTodosDoCanteiro(Long idCanteiro);

    
}