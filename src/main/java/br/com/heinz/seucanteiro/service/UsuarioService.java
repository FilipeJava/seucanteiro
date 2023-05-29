package br.com.heinz.seucanteiro.service;

import br.com.heinz.seucanteiro.model.Usuario;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario atualizar(Usuario usuario);

    void deletar(Long id);

    Usuario buscaPorCpf(String cpf);

}