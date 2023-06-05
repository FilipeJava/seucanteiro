package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.PerguntaUsuario;

public interface PerguntaUsuarioRepository extends JpaRepository<PerguntaUsuario, Long> {
    
}