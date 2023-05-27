package br.com.heinz.seucanteiro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespostaDTO {

    /*Resposta enviada do back para o front para manipulacoes de dados */

    private Long id;

    private String email;


}
