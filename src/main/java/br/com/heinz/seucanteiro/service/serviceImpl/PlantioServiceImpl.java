package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.exception.RestNotFoundException;
import br.com.heinz.seucanteiro.model.Plantio;
import br.com.heinz.seucanteiro.repository.PlantioRepository;
import br.com.heinz.seucanteiro.service.PlantioService;

@Service
public class PlantioServiceImpl implements PlantioService {

    @Autowired
    PlantioRepository plantioRepository;

    @Autowired
    PlantaServiceImpl plantaServiceImpl;

    @Override
    public Plantio salvar(Plantio plantio) {
        return plantioRepository.save(plantio);
    }

    @Override
    public Plantio buscaId(Long id) {
        return plantioRepository.findById(id).get();
    }

    @Override
    public List<Plantio> buscaTodos() {
        return plantioRepository.findAll();
    }

    public List<Plantio> buscaTodosDoCanteiro(Long idCanteiro) {
        return plantioRepository.findAllByCanteiroId(idCanteiro);
    }

    @Override
    public void deletar(Long id) {
        var plantio = getPlantio(id);
        plantioRepository.delete(plantio);
    }

    public Plantio getPlantio(Long id) {
        return plantioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantio não encontrado"));
    }

}