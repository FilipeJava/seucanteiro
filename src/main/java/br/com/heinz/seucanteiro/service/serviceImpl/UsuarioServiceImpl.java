package br.com.heinz.seucanteiro.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.repository.UsuarioRepository;
import br.com.heinz.seucanteiro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Override
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);

    }

    @Override
    public Usuario buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public Usuario buscaPorCpf(String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscaPorCpf'");
    }

}