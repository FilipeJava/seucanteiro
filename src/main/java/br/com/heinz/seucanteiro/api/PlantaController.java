package br.com.heinz.seucanteiro.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.dto.resposta.PlantaPlantioRespostaDTO;
import br.com.heinz.seucanteiro.dto.resposta.PlantaRespostaDTO;
import br.com.heinz.seucanteiro.model.Planta;
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

    // post para criar planta e plantio ao mesmo tempo

    @PostMapping("{idCanteiro}")
    public ResponseEntity<PlantaRespostaDTO> salvar(@PathVariable Long idCanteiro,
            @RequestBody PlantaPlantio plantaPlantio) {

        log.info("Salvando planta");

        return ResponseEntity.ok(plantaPlantioServiceImpl.salvar(idCanteiro, plantaPlantio));

        // return
        // ResponseEntity.status(HttpStatus.CREATED).body(plantaPlantioServiceImpl.salvar(idCanteiro,
        // plantaPlantio));

    }

    // put para atualizar planta e plantio ao mesmo tempo
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

    // delete a planta e o plantio que por cascade é deletado junto
    @DeleteMapping("{idPlanta}")
    public ResponseEntity<?> deletar(@PathVariable Long idPlanta) {
        {
            log.info("Deletando planta");
            plantioServiceImpl.deletar(idPlanta);
            return ResponseEntity.noContent().build();
        }

    }

    // get para busca todas as plantas plantio
    @GetMapping()
    public ResponseEntity<List<PlantaPlantioRespostaDTO>> buscarTodos() {
        {
            log.info("Buscando todas as plantas");
            return ResponseEntity.ok(plantaPlantioServiceImpl.buscaTodos());
        }

    }

    // get para busca todas as plantas plantio tem paginação e busca por nome para
    // atender as requisições da GS mas não será implantada no app

    @GetMapping("/page")
    public Page<Planta> index(
            @RequestParam(required = false) String nome, @PageableDefault(size = 5) Pageable pageable) {
        Page<Planta> plantas = (nome == null) ? plantaServiceImpl.buscaTodos(pageable)
                : plantaServiceImpl.findNomeContem(nome, pageable);

        return plantas;

    }

}
