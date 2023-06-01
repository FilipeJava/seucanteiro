package br.com.heinz.seucanteiro.service;



import java.util.List;

import br.com.heinz.seucanteiro.model.Plantio;

public interface PlantioService {

    Plantio salvar(Plantio plantio);
    
    Plantio buscaId(Long id);

    List<Plantio>buscaTodos();

    void deletar(Long idPlanta);
}