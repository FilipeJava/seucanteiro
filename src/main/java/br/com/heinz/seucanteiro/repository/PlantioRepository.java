package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.Plantio;

public interface PlantioRepository extends JpaRepository<Plantio, Long> {
    
}