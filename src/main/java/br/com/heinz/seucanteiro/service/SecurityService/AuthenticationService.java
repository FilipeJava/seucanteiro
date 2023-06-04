package br.com.heinz.seucanteiro.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.repository.LoginRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("usuário não encontrado"));
    }


    
}
