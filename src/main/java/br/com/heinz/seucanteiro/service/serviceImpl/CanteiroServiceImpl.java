package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.form.CanteiroFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.CanteiroRespostaDTO;
import br.com.heinz.seucanteiro.model.Canteiro;
import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.repository.CanteiroRepository;
import br.com.heinz.seucanteiro.service.CanteiroService;

@Service
public class CanteiroServiceImpl implements CanteiroService {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    CanteiroRepository canteiroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CanteiroRespostaDTO save(Usuario usuario) {

        Canteiro canteiro = new Canteiro();

        canteiro.setNome("Canteiro de " + usuario.getNome());
        canteiro.setUsuario(usuario);
        canteiroRepository.save(canteiro);

        return convertToResposta(canteiro);

    }

    @Override
    public void delete(Long id) {
        canteiroRepository.deleteById(id);
    }

    @Override
    public Canteiro findById(Long id) {
        return canteiroRepository.findById(id).get();
    }

    @Override
    public List<Canteiro> getAll() {
        return canteiroRepository.findAll();
    }

    @Override
    public CanteiroRespostaDTO update(CanteiroFormDTO canteiro, Long id) {
        Canteiro canteiroAtualizar = findById(id);
        canteiroAtualizar.setNome(canteiro.getNome());
        return convertToResposta(canteiroRepository.save(canteiroAtualizar));

    }

    private CanteiroRespostaDTO convertToResposta(Canteiro canteiro) {
        return modelMapper.map(canteiro, CanteiroRespostaDTO.class);
    }

}