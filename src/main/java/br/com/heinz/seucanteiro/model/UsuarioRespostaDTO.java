package br.com.heinz.seucanteiro.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRespostaDTO {

    /* Resposta get do usuario que vira do back */

    @NotNull
    private Long id;

    @NotBlank @Size(min = 3)
    private String nome;

    @NotBlank
    private String cpf;

    @NotNull
    private LocalDateTime dataNascimento;

    @NotBlank
    private String telefone;

}