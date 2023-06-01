package br.com.heinz.seucanteiro.dto.form;

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
public class PlantaFormDTO {


    /* Requisiçao post do usuario que vira do front */

    @NotBlank @Size(min = 3)
    private String nome;

    @NotNull
    private Integer regacao;

  
    private String nomeCientifico;

   
    private String apelido;

    
}