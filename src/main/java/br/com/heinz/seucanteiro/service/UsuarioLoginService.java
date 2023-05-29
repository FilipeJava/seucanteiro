package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.model.UsuarioLogin;
import br.com.heinz.seucanteiro.model.UsuarioRespostaDTO;

public interface UsuarioLoginService {

    

   UsuarioRespostaDTO salvar(UsuarioLogin usuarioLogin);

}