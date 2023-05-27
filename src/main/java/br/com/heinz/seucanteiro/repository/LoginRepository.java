package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findByEmail(String email);
    
}