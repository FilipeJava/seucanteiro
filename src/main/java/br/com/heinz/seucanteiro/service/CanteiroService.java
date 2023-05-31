package br.com.heinz.seucanteiro.service;

import java.util.List;

import br.com.heinz.seucanteiro.dto.CanteiroFormDTO;
import br.com.heinz.seucanteiro.dto.CanteiroRespostaDTO;
import br.com.heinz.seucanteiro.model.Canteiro;
import br.com.heinz.seucanteiro.model.Usuario;

public interface CanteiroService {


    CanteiroRespostaDTO save(Usuario usuario);

    void delete(Long id);

    CanteiroRespostaDTO update( CanteiroFormDTO canteiro, Long id);

    Canteiro findById(Long id);

    List<Canteiro> getAll();

   

}