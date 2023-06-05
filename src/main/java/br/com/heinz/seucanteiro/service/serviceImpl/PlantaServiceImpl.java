package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.exception.RestNotFoundException;
import br.com.heinz.seucanteiro.model.Planta;
import br.com.heinz.seucanteiro.repository.PlantaRepository;
import br.com.heinz.seucanteiro.service.PlantaService;

@Service
public class PlantaServiceImpl implements PlantaService {

   @Autowired
   PlantaRepository plantaRepository;

   // Metodo Para Salvar uma Planta
   @Override
   public Planta salvar(Planta planta) {
      return plantaRepository.save(planta);
   }

   // Metodo Para Buscar uma Planta por Id
   @Override
   public Planta buscaId(Long id) {
      return plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Planta não encontrada"));
   }

   // Metodo Para Buscar Todos as Plantas
   @Override
   public Page<Planta>buscaTodos( Pageable pageable) {
      return plantaRepository.findAll( pageable);
   }

   @Override
   public Page<Planta> findNomeContem(String nome, Pageable pageable) {
      return plantaRepository.findByNomeContaining(nome, pageable);  }

}