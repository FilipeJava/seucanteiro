package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.model.Planta;
import br.com.heinz.seucanteiro.repository.PlantaRepository;
import br.com.heinz.seucanteiro.service.PlantaService;

@Service
public class PlantaServiceImpl implements PlantaService {

    @Autowired
    PlantaRepository plantaRepository;


    @Override
    public Planta salvar(Planta planta) {
       return plantaRepository.save(planta);
    }


  


    @Override
    public Planta buscaId(Long id) {
       return plantaRepository.findById(id).get();
    }





    @Override
    public List<Planta> buscaTodos() {
       return plantaRepository.findAll();
    }
    
}