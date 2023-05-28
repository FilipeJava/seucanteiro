package br.com.heinz.seucanteiro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CanteiroRespostaDTO {


    private Long id;

    private String nome;
    
}