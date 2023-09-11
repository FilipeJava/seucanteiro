package br.com.heinz.seucanteiro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.heinz.seucanteiro.model.Planta;

public interface PlantaService {

    Planta salvar(Planta planta);

    Planta buscaId(Long id);

    Page<Planta> buscaTodos(Pageable pageable);

    Page<Planta> findNomeContem(String nome, Pageable pageable);

}