package br.com.heinz.seucanteiro.dto;

import java.time.LocalDate;

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
public class UsuarioFormDTO {


    /* Requisiçao post do usuario que vira do front */

   @NotBlank @Size(min = 3)
    private String nome;

   @NotBlank
    private String cpf;

   @NotNull
    private LocalDate dataNascimento;

   @NotBlank
    private String telefone;

 

    
}