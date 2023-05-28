package br.com.heinz.seucanteiro.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CanteiroRespostaDTO {

    @NotNull
    private Long id;

    @NotBlank @Size(min = 3)
    private String nome;
    
}