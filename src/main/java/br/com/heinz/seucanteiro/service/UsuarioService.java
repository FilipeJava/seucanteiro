package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.model.LoginFormDTO;
import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.model.UsuarioFormDTO;
import br.com.heinz.seucanteiro.model.UsuarioRespostaDTO;

public interface UsuarioService {

    UsuarioRespostaDTO salvar(UsuarioFormDTO usuarioFormDTO, LoginFormDTO login);

    Usuario buscarPorId(Long id);

    Usuario atualizar(Long id, UsuarioFormDTO usuarioFormDTO);

    void deletar(Long id);

    Usuario buscaPorCpf(String cpf);

}