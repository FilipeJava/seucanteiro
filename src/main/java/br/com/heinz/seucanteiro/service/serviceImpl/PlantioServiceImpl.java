package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.model.Plantio;
import br.com.heinz.seucanteiro.repository.PlantioRepository;
import br.com.heinz.seucanteiro.service.PlantioService;

@Service
public class PlantioServiceImpl implements PlantioService {

    @Autowired
    PlantioRepository plantioRepository;

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



}