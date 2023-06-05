package br.com.heinz.seucanteiro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.heinz.seucanteiro.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    // Optional<Login> findByEmail(String email); // padrao do spring data

    @Query("SELECT l FROM T_CAN_LOGIN l WHERE l.email = :email")  // JPQL para atender o requisito de buscar login pelo email , atender Entrega ENTERPRISE APPLICATION DEVELOPMENT
    Optional<Login> findByEmail(String email);

}