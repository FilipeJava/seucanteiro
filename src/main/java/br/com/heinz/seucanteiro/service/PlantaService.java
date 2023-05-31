package br.com.heinz.seucanteiro.service;

import java.util.List;

import br.com.heinz.seucanteiro.model.Planta;

public interface PlantaService {

    Planta salvar(Planta planta);

    Planta buscaId(Long id);

    List<Planta> buscaTodos();

}