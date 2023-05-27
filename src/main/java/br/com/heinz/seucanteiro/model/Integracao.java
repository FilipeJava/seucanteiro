package br.com.heinz.seucanteiro.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_INTEGRACAO")
public class Integracao {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID_INTEGRACAO")
private Long id;    
    
@Column(name = "ID_CONTEXTO")
private Long idContexto;

@Column(name = "DS_ASSUNTO")
private String assunto;

@Column(name = "DT_INTEGRACAO")
private LocalDate dataIntegracao;

private Bot bot;

private Usuario usuario;

private List<RespostaBot> respostas;

private List<PerguntaUsuario> perguntas;



}