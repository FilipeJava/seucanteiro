package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.form.UsuarioFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.exception.RestNotFoundException;
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

    // Metodo para salva um usuario
    @Override
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    // Metodo para buscar um usuario por id e retonra um DTOResposta
    @Override
    public UsuarioRespostaDTO buscarPorId(Long id) {
        return convertToRespostaUsuario(getUsuario(id));
    }

    // Metodo para atualizar um usuario
    @Override
    public UsuarioRespostaDTO atualizar(Long id, UsuarioFormDTO usuario) {
        Usuario usuarioSalvo = usuarioRepository.findById(id).get();
        usuarioSalvo.setNome(usuario.getNome());
        usuarioSalvo.setCpf(usuario.getCpf());
        usuarioSalvo.setDataNascimento(usuario.getDataNascimento());
        usuarioSalvo.setTelefone(usuario.getTelefone());

        usuarioRepository.save(usuarioSalvo);

        return convertToRespostaUsuario(usuarioSalvo);
    }

    // Metodo para deletar um usuario e por cascade deletar o login e cantreiro
    // plantio e planta
    @Override
    public void deletarPorId(Long id) {
        var usuario = getUsuario(id);
        usuarioRepository.delete(usuario);
    }

    // metodo para criacao de jpql para buscar usuario por cpf nao tera
    // funcionalidade no momento mas precisa ter para entrega do projeto
    @Override
    public Usuario buscaPorCpf(String cpf) {

        throw new UnsupportedOperationException("Unimplemented method 'buscaPorCpf'");
    }

    // DTO METHODS
    private UsuarioRespostaDTO convertToRespostaUsuario(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespostaDTO.class);
    }

    // Metodo para buscar um usuario por id
    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado"));
    }

}