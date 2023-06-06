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

    // Metodo Para Salvar um Plantio
    @Override
    public Plantio salvar(Plantio plantio) {
        return plantioRepository.save(plantio);
        
    }

    // Metodo Para Buscar um Plantio por Id
    @Override
    public Plantio buscaId(Long id) {
        return plantioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantio não encontrado"));
    }

    // Metodo Para Buscar Todos os Plantios
    @Override
    public List<Plantio> buscaTodos() {
        return plantioRepository.findAll();
    }

    // Metodo Para Buscar Todos os Plantios de um Canteiro
    public List<Plantio> buscaTodosDoCanteiro(Long idCanteiro) {
        return plantioRepository.findAllByCanteiroId(idCanteiro);
    }

    // Metodo Para Deletar um Plantio e por cascade deletar as plantas
    @Override
    public void deletar(Long id) {
        var plantio = buscaId(id);
        plantioRepository.delete(plantio);
    }

}