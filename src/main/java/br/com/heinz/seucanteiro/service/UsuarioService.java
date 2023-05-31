package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.dto.UsuarioFormDTO;
import br.com.heinz.seucanteiro.dto.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.model.Usuario;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    UsuarioRespostaDTO buscarPorId(Long id);

    UsuarioRespostaDTO atualizar( Long id ,UsuarioFormDTO usuarioform);

    void deletarPorId (Long id);

    Usuario buscaPorCpf(String cpf);

}