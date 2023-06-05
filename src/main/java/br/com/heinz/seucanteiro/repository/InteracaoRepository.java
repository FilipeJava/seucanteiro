package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.Interacao;

public interface InteracaoRepository  extends JpaRepository<Interacao, Long>{
    
}