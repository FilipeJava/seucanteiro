package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.model.LoginFormDTO;
import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.model.UsuarioFormDTO;
import br.com.heinz.seucanteiro.model.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.repository.UsuarioRepository;
import br.com.heinz.seucanteiro.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Usuario salvar(UsuarioFormDTO usuarioFormDTO, LoginFormDTO login) {
    
        // criar usuario 
        Usuario usuario = convertToEntity(usuarioFormDTO);

        // criar login
        Login loginEntity = loginServiceImpl.save(login);

        // setar login no usuario
        usuario.setLogin(loginEntity);

        // salvar usuario
        return usuarioRepository.save(usuario);
    
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Usuario atualizar(Long id, UsuarioFormDTO usuarioFormDTO) {
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
    

    private Usuario convertToEntity(UsuarioFormDTO usuarioFormDTO) {
        return modelMapper.map( usuarioFormDTO, Usuario.class);

    }

    private UsuarioRespostaDTO convertToResposta(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespostaDTO.class);
    }
}