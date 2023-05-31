package br.com.heinz.seucanteiro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantaRespostaDTO {

    private Long id;

    private String nome;

    private Integer regacao;

    private String nomeCientifico;

    private String apelido;

}