package br.com.heinz.seucanteiro.dto.resposta;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantioRespostaDTO {

   
    private Long id;

    private Integer quantidadePlantada;

    private LocalDate dataPlantio;

    private LocalDate dataColheita;

  
    
}