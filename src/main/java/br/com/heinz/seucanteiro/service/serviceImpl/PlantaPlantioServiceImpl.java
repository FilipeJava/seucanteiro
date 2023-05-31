package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.PlantaFormDTO;
import br.com.heinz.seucanteiro.dto.PlantaRespostaDTO;
import br.com.heinz.seucanteiro.dto.PlantioFormDTO;
import br.com.heinz.seucanteiro.dto.PlantioRespostaDTO;
import br.com.heinz.seucanteiro.model.Canteiro;
import br.com.heinz.seucanteiro.model.Planta;
import br.com.heinz.seucanteiro.model.PlantaPlantio;
import br.com.heinz.seucanteiro.model.Plantio;
import br.com.heinz.seucanteiro.service.PlantaPlantioService;

@Service
public class PlantaPlantioServiceImpl implements PlantaPlantioService {

    @Autowired
    PlantioServiceImpl plantioServiceImpl;

    @Autowired
    PlantaServiceImpl plantaServiceImpl;

    @Autowired
    CanteiroServiceImpl canteiroServiceImpl;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PlantaRespostaDTO salvar(Long idCanteiro, PlantaPlantio plantaPlantio) {

        // regastar dados do canteiro
        Canteiro canteiro = canteiroServiceImpl.findById(idCanteiro);

        // salvar planta
        Planta planta = plantaServiceImpl.salvar(convertToEntityPlanta(plantaPlantio.getPlanta()));

        // criar plantio
        Plantio plantio = convertToEntityPlantio(plantaPlantio.getPlantio());

        // setar planta e canteiro no plantio

        plantio.setPlanta(planta);
        plantio.setCanteiro(canteiro);

        // salvar plantio
        plantio = plantioServiceImpl.salvar(plantio);

        return convertToRespostaPlanta(planta);




    }

    // DTO METHODS
    private Planta convertToEntityPlanta(PlantaFormDTO plantaform) {
        return modelMapper.map(plantaform, Planta.class);

    }

    private PlantaRespostaDTO convertToRespostaPlanta(Planta planta) {
        return modelMapper.map(planta, PlantaRespostaDTO.class);
    }

    private Plantio convertToEntityPlantio(PlantioFormDTO plantioform) {
        return modelMapper.map(plantioform, Plantio.class);

    }

    private PlantioRespostaDTO convertToRespostaPlantio(Plantio plantio) {
        return modelMapper.map(plantio, PlantioRespostaDTO.class);
    }

}