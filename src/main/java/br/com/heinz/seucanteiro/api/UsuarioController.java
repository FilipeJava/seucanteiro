package br.com.heinz.seucanteiro.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.dto.form.UsuarioFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.model.UsuarioLogin;
import br.com.heinz.seucanteiro.service.serviceImpl.LoginServiceImpl;
import br.com.heinz.seucanteiro.service.serviceImpl.UsuarioLoginServiceImpl;
import br.com.heinz.seucanteiro.service.serviceImpl.UsuarioServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioLoginServiceImpl usuarioLoginServiceImpl;

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    // metodo para salvar usuario recebendo um usuarioFormDTO e um loginFormDTO
    @PostMapping
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody @Valid UsuarioLogin usuarioLogin) {

        log.info("Salvando usuario");

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioLoginServiceImpl.salvar(usuarioLogin));

    }

    // metodo para buscar usuario por id
    @GetMapping("{id}")
    public ResponseEntity<UsuarioRespostaDTO> buscarPorId(@PathVariable Long id) {
        log.info("Buscando usuario por id");
        return ResponseEntity.ok(usuarioServiceImpl.buscarPorId(id));
    }

    // metodo para deletar usuario por id que por cascade deleta o login
    @DeleteMapping("{id}")
    public ResponseEntity<UsuarioRespostaDTO> deletar(@PathVariable Long id) {
        log.info("Deletando usuario por id");
        usuarioServiceImpl.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

    // metodo para atualizar usuario isoladamente
    @PutMapping("{id}")
    public ResponseEntity<UsuarioRespostaDTO> atualizaUsuario(@PathVariable Long id,
            @RequestBody UsuarioFormDTO usuarioFormDTO) {
        log.info("Atualizando usuario");
        return ResponseEntity.ok(usuarioServiceImpl.atualizar(id, usuarioFormDTO));
    }
}