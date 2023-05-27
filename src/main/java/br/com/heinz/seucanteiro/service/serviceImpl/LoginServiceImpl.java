package br.com.heinz.seucanteiro.service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.model.LoginFormDTO;
import br.com.heinz.seucanteiro.model.LoginRespostaDTO;
import br.com.heinz.seucanteiro.repository.LoginRepository;
import br.com.heinz.seucanteiro.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Login save(LoginFormDTO login) {
        Login loginEntity = convertToEntity(login);
        return loginRepository.save(loginEntity);
    }

    @Override
    public LoginRespostaDTO findByEmail(String email) {
        return convertToResposta(loginRepository.findByEmail(email));
    }

    @Override
    public LoginRespostaDTO getLogin(Long id) {
        return convertToResposta(loginRepository.findById(id).get());
    }

    @Override
    public void delete(Long id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Login update(LoginFormDTO login) {
        return loginRepository.save(convertToEntity(login));
    }

    @Override
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    private Login convertToEntity(LoginFormDTO loginform) {
        return modelMapper.map(loginform, Login.class);

    }

    private LoginRespostaDTO convertToResposta(Login login) {
        return modelMapper.map(login, LoginRespostaDTO.class);
    }

}