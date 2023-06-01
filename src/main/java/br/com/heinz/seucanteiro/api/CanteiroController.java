package br.com.heinz.seucanteiro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.dto.PlantaPlantioRespostaDTO;

import br.com.heinz.seucanteiro.service.serviceImpl.PlantaPlantioServiceImpl;

@RestController
@RequestMapping("/api/v1/canteiro")
public class CanteiroController {

    @Autowired
    PlantaPlantioServiceImpl plantaPlantioServiceImpl;

    // recuperar todas as plantaplantios de um canteiro
    @GetMapping("{idCanteiro}")
    public ResponseEntity<List<PlantaPlantioRespostaDTO>> buscaTodosDoCanteiro(@PathVariable Long idCanteiro) {

        return ResponseEntity.ok(plantaPlantioServiceImpl.buscaTodosDoCanteiro(idCanteiro));
    }
}