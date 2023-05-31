package br.com.heinz.seucanteiro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private Long id;

    @NotBlank
    @Email
    private String email;


}
