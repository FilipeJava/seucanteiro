package br.com.heinz.seucanteiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.heinz.seucanteiro.model.Plantio;

public interface PlantioRepository extends JpaRepository<Plantio, Long> {

    List<Plantio> findAllByCanteiroId(Long idCanteiro);

    @Query("SELECT p FROM T_CAN_PLANTIO p")  // JPQL para atender o requisito de buscar todos os plantios , atender Entrega ENTERPRISE APPLICATION DEVELOPMENT
    List<Plantio> findAll();

   

    
}