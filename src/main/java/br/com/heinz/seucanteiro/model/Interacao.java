package br.com.heinz.seucanteiro.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_INTERACAO")
public class Interacao {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID_INTERACAO")
private Long id;    
    
@Column(name = "ID_CONTEXTO")
@NotNull
private Long idContexto;

@Column(name = "DS_ASSUNTO")
@NotBlank
private String assunto;

@Column(name = "DT_INTERACAO")
@NotNull
private LocalDate dataInteracao;

private Bot bot;

private Usuario usuario;

private List<RespostaBot> respostas;

private List<PerguntaUsuario> perguntas;



}