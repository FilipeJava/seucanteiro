package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.heinz.seucanteiro.model.Canteiro;


public interface CanteiroRepository extends JpaRepository<Canteiro, Long> {
    
}