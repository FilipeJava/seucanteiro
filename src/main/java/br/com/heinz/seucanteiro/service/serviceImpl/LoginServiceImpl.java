package br.com.heinz.seucanteiro.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.exception.RestNotFoundException;
import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.repository.LoginRepository;
import br.com.heinz.seucanteiro.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login salvar(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login buscarPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorEmail'");
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
    public Login atualizaLogin(Login login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizaLogin'");
    }

  

}