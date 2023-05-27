package br.com.heinz.seucanteiro.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRespostaDTO {

    private Long id;

    private String nome;

    private String cpf;

    private LocalDateTime dataNascimento;

    private String telefone;

}