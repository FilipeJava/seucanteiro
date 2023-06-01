package br.com.heinz.seucanteiro.service;

import org.springframework.web.bind.MethodArgumentNotValidException;

import br.com.heinz.seucanteiro.dto.resposta.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.model.UsuarioLogin;

public interface UsuarioLoginService {

    

   UsuarioRespostaDTO salvar(UsuarioLogin usuarioLogin) throws MethodArgumentNotValidException;

  


}