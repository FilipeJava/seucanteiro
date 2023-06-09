package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.form.PlantaFormDTO;
import br.com.heinz.seucanteiro.dto.form.PlantioFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantaPlantioRespostaDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantaRespostaDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantioRespostaDTO;
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

    // Metdodo PlantaPlantio que salva a planta e o plantio ao mesmo tempo
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

    // Metodo Planta Plantio que atualiza a planta e o plantio ao mesmo tempo
    @Override
    public PlantaRespostaDTO autaliza(Long idPlanta, PlantaPlantio plantaPlantio) {

        // busca planta e atualiza
        Planta planta = plantaServiceImpl.buscaId(idPlanta);
        planta.setNome(plantaPlantio.getPlanta().getNome());
        planta.setNomeCientifico(plantaPlantio.getPlanta().getNomeCientifico());
        planta.setApelido(plantaPlantio.getPlanta().getApelido());

        // grava planta atualizada
        plantaServiceImpl.salvar(planta);

        // busca plantio e atualiza que tem o mesmo id da planta
        Plantio plantio = plantioServiceImpl.buscaId(idPlanta);
        plantio.setDataPlantio(plantaPlantio.getPlantio().getDataPlantio());
        plantio.setQuantidadePlantada(plantaPlantio.getPlantio().getQuantidadePlantada());
        plantio.setPlanta(planta);
        plantio.setDataColheita(plantaPlantio.getPlantio().getDataColheita());

        // Salva plantio atualizado
        plantioServiceImpl.salvar(plantio);

        return convertToRespostaPlanta(planta);

    }

    // Metodo que busca a planta e o plantio pelo id, ambos tem o mesmo id pois são
    // salvos ao mesmo tempo
    @Override
    public PlantaPlantioRespostaDTO buscaId(Long idPlanta) {

        // busco planta e plantio pelo id
        Planta planta = plantaServiceImpl.buscaId(idPlanta);
        Plantio plantio = plantioServiceImpl.buscaId(idPlanta);

        // crio objeto plantaPlantio e seto planta e plantio
        PlantaPlantioRespostaDTO plantaPlantio = new PlantaPlantioRespostaDTO();
        plantaPlantio.setPlanta(convertToRespostaPlanta(planta));
        plantaPlantio.setPlantio(convertToRespostaPlantio(plantio));

        return plantaPlantio;

    }

    // Metodo que busca todo as plantas e plantios do canteiro
    @Override
    public List<PlantaPlantioRespostaDTO> buscaTodosDoCanteiro(Long idCanteiro) {
        // busca todos os plantios do canteiro
        List<Plantio> plantios = plantioServiceImpl.buscaTodosDoCanteiro(idCanteiro);

        // crio lista de plantasPlantio
        List<PlantaPlantioRespostaDTO> plantasPlantio = new ArrayList<PlantaPlantioRespostaDTO>();

        // percorro a lista de plantios e crio um objeto plantaPlantio e seto planta e
        // plantio
        for (Plantio plantio : plantios) {
            PlantaPlantioRespostaDTO plantaPlantio = new PlantaPlantioRespostaDTO();
            plantaPlantio.setPlanta(convertToRespostaPlanta(plantio.getPlanta()));
            plantaPlantio.setPlantio(convertToRespostaPlantio(plantio));

            // adiciono o objeto plantaPlantio na lista
            plantasPlantio.add(plantaPlantio);
        }

        return plantasPlantio;
    }



    // metodo que busca todas as plantas e plantios
    // nao será necessario para o sistema mobile , mas é para atender requisitos da Global Solution JPQ
    @Override
    public List<PlantaPlantioRespostaDTO> buscaTodos() {
        // busca todos os plantios
        List<Plantio> plantios = plantioServiceImpl.buscaTodos();

        // crio lista de plantasPlantio
        List<PlantaPlantioRespostaDTO> plantasPlantio = new ArrayList<PlantaPlantioRespostaDTO>();

        // percorro a lista de plantios e crio um objeto plantaPlantio e seto planta e
        // plantio
        for (Plantio plantio : plantios) {
            PlantaPlantioRespostaDTO plantaPlantio = new PlantaPlantioRespostaDTO();
            plantaPlantio.setPlanta(convertToRespostaPlanta(plantio.getPlanta()));
            plantaPlantio.setPlantio(convertToRespostaPlantio(plantio));

            // adiciono o objeto plantaPlantio na lista
            plantasPlantio.add(plantaPlantio);
        }

        return plantasPlantio;
    }


    
    // DTO METHODS
    private Planta convertToEntityPlanta(PlantaFormDTO plantaform) {
        return modelMapper.map(plantaform, Planta.class);

    }

    private PlantaRespostaDTO convertToRespostaPlanta(Planta planta) {
        return modelMapper.map(planta, PlantaRespostaDTO.class);
    }

    private PlantioRespostaDTO convertToRespostaPlantio(Plantio plantio) {
        return modelMapper.map(plantio, PlantioRespostaDTO.class);
    }

    private Plantio convertToEntityPlantio(PlantioFormDTO plantioform) {
        return modelMapper.map(plantioform, Plantio.class);

    }

    // converte model planta para Plantaformdto
    private PlantaFormDTO convertToFormPlanta(Planta planta) {
        return modelMapper.map(planta, PlantaFormDTO.class);
    }

    // converte model plantio para Plantioformdto
    private PlantioFormDTO convertToFormPlantio(Plantio plantio) {
        return modelMapper.map(plantio, PlantioFormDTO.class);
    }

   

}