package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.RespostaBot;

public interface RespostaBotRepository  extends JpaRepository<RespostaBot, Long>{
    
}