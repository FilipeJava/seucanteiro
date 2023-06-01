package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.form.UsuarioFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.repository.UsuarioRepository;
import br.com.heinz.seucanteiro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    public  UsuarioRespostaDTO buscarPorId(Long id) {
        return  convertToRespostaUsuario( usuarioRepository.findById(id).get());
    }

    @Override
    public UsuarioRespostaDTO atualizar (Long id, UsuarioFormDTO usuario) {
        Usuario usuarioSalvo = usuarioRepository.findById(id).get();
        usuarioSalvo.setNome(usuario.getNome());
        usuarioSalvo.setCpf(usuario.getCpf());
        usuarioSalvo.setDataNascimento(usuario.getDataNascimento());
        usuarioSalvo.setTelefone(usuario.getTelefone());
        
        usuarioRepository.save(usuarioSalvo);

        return convertToRespostaUsuario(usuarioSalvo) ;
    }

    @Override
    public void deletarPorId(Long id)  {
        usuarioRepository.delete(usuarioRepository.findById(id).get());
    }

    @Override
    public Usuario buscaPorCpf(String cpf) {

        throw new UnsupportedOperationException("Unimplemented method 'buscaPorCpf'");
    }


    private UsuarioRespostaDTO convertToRespostaUsuario(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespostaDTO.class);
    }

}