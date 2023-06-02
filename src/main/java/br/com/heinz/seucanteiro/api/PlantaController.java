package br.com.heinz.seucanteiro.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.dto.resposta.PlantaPlantioRespostaDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantaRespostaDTO;
import br.com.heinz.seucanteiro.model.PlantaPlantio;
import br.com.heinz.seucanteiro.service.serviceImpl.PlantaPlantioServiceImpl;
import br.com.heinz.seucanteiro.service.serviceImpl.PlantaServiceImpl;
import br.com.heinz.seucanteiro.service.serviceImpl.PlantioServiceImpl;

@RestController
@RequestMapping("/api/v1/planta")

public class PlantaController {

    @Autowired
    PlantaPlantioServiceImpl plantaPlantioServiceImpl;

    @Autowired
    PlantaServiceImpl plantaServiceImpl;

    @Autowired
    PlantioServiceImpl plantioServiceImpl;

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    // post

    @PostMapping("{idCanteiro}")
    public ResponseEntity<PlantaRespostaDTO> salvar(@PathVariable Long idCanteiro,
            @RequestBody PlantaPlantio plantaPlantio) {
        {
            log.info("Salvando planta");
            return ResponseEntity.ok(plantaPlantioServiceImpl.salvar(idCanteiro, plantaPlantio));

        }

    }

    // put
    @PutMapping("{idPlanta}")
    public ResponseEntity<PlantaRespostaDTO> atualizar(@PathVariable Long idPlanta,
            @RequestBody PlantaPlantio plantaPlantio) {
        {
            log.info("Atualizando planta");
            return ResponseEntity.ok(plantaPlantioServiceImpl.autaliza(idPlanta, plantaPlantio));

        }

    }

    // get para busca planta plantio por id
    @GetMapping("{idPlanta}")
    public ResponseEntity<PlantaPlantioRespostaDTO> buscarId(@PathVariable Long idPlanta) {
        {
            log.info("Buscando planta");
            return ResponseEntity.ok(plantaPlantioServiceImpl.buscaId(idPlanta));
        }

    }

    // delete a planta e o plantio
    @DeleteMapping("{idPlanta}")
    public ResponseEntity<?> deletar(@PathVariable Long idPlanta) {
        {
            log.info("Deletando planta");
            plantioServiceImpl.deletar(idPlanta);
            return ResponseEntity.ok().build();
        }

    }

}