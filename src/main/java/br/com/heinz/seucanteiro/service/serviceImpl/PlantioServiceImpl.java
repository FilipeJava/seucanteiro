package br.com.heinz.seucanteiro.service.serviceImpl;

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



}