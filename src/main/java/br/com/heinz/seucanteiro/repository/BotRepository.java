package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.Bot;

public interface BotRepository extends JpaRepository<Bot, Long> {
    
}