package br.com.heinz.seucanteiro.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.heinz.seucanteiro.model.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

    // Page<Planta> findByNomeContaining(String nome, Pageable pageable);


    @Query("SELECT p FROM T_CAN_PLANTAS p WHERE p.nome LIKE %:nome%")
Page<Planta> findByNomeContaining(@Param("nome") String nome, Pageable pageable);

    
}