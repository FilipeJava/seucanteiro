package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.form.LoginFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.LoginRespostaDTO;
import br.com.heinz.seucanteiro.exception.RestNotFoundException;
import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.repository.LoginRepository;
import br.com.heinz.seucanteiro.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Login salvar(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login buscarPorEmail(String email) {
        return loginRepository.findByEmail(email).orElseThrow(() -> new RestNotFoundException("Login não encontrado"));
    }

    @Override
    public Login buscaLogin(Long id) {
        return loginRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Login não encontrado"));
    }

    @Override
    public void deletaLogin(Long id) {
        loginRepository.delete(buscaLogin(id));

    }

    @Override
    public LoginRespostaDTO atualizaLogin( Long id ,LoginFormDTO login) {
        var loginAtualizado = buscaLogin(id);
        loginAtualizado.setEmail(login.getEmail());
        loginAtualizado.setSenha(login.getSenha());
        return convertToRespostaLogin(salvar(loginAtualizado));


    }



    private Login convertToEntityLogin(LoginFormDTO loginform) {
        return modelMapper.map(loginform, Login.class);

    }

    private LoginRespostaDTO convertToRespostaLogin(Login login) {
        return modelMapper.map(login, LoginRespostaDTO.class);

    }
  

}