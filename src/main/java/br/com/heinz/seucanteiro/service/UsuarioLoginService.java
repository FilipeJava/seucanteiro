package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.dto.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.model.UsuarioLogin;

public interface UsuarioLoginService {

    

   UsuarioRespostaDTO salvar(UsuarioLogin usuarioLogin);

  


}