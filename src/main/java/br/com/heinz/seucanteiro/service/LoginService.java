package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.dto.form.LoginFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.LoginRespostaDTO;
import br.com.heinz.seucanteiro.model.Login;

public interface LoginService {

    Login salvar(Login login);

    Login buscarPorEmail(String email);

    Login buscaLogin(Long id);

    void deletaLogin(Long id);

    LoginRespostaDTO atualizaLogin(Long id, LoginFormDTO login);

}