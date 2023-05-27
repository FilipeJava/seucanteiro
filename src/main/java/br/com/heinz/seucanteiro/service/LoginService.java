package br.com.heinz.seucanteiro.service;

import java.util.List;

import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.model.LoginFormDTO;
import br.com.heinz.seucanteiro.model.LoginRespostaDTO;

public interface LoginService {


    Login save(LoginFormDTO login);

    LoginRespostaDTO findByEmail(String email);

    LoginRespostaDTO getLogin(Long id);

    void delete(Long id);

    Login update(LoginFormDTO login);

    List<Login> findAll();
    
}