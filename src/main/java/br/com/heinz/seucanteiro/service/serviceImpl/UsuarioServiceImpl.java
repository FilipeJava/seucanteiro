package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.model.LoginFormDTO;
import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.model.UsuarioFormDTO;
import br.com.heinz.seucanteiro.model.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.repository.UsuarioRepository;
import br.com.heinz.seucanteiro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioRespostaDTO salvar(UsuarioFormDTO usuarioFormDTO, LoginFormDTO login) {

        // chumbar canteiro para teste
                

        // criar usuario
        Usuario usuario = convertToEntity(usuarioFormDTO);

        // criar login
        Login loginEntity = loginServiceImpl.save(login);

        // setar login no usuario
        usuario.setLogin(loginEntity);

        // salvar usuario
        return convertToResposta(usuarioRepository.save(usuario));

    }


    
    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @Override
    public Usuario atualizar(Long id, UsuarioFormDTO usuarioFormDTO) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioFormDTO.getNome());
            usuario.setCpf(usuarioFormDTO.getCpf());
            usuario.setDataNascimento(usuarioFormDTO.getDataNascimento());
            usuario.setTelefone(usuarioFormDTO.getTelefone());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario buscaPorCpf(String cpf) {

        return usuarioRepository.findByCpf(cpf);
    }

    // DTO METHODS
    private Usuario convertToEntity(UsuarioFormDTO usuarioFormDTO) {
        return modelMapper.map(usuarioFormDTO, Usuario.class);

    }

    private UsuarioRespostaDTO convertToResposta(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespostaDTO.class);
    }
}