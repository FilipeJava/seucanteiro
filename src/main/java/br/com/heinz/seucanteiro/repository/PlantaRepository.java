package br.com.heinz.seucanteiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heinz.seucanteiro.model.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Long> {
    
}