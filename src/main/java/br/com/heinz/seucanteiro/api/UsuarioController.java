package br.com.heinz.seucanteiro.api;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.model.LoginFormDTO;
import br.com.heinz.seucanteiro.model.UsuarioFormDTO;
import br.com.heinz.seucanteiro.model.UsuarioLogin;
import br.com.heinz.seucanteiro.model.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.service.serviceImpl.UsuarioLoginServiceImpl;
import br.com.heinz.seucanteiro.service.serviceImpl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/v1/usuario/")
public class UsuarioController {

    @Autowired
    UsuarioLoginServiceImpl usuarioLoginServiceImpl;

    org.slf4j.Logger log = LoggerFactory.getLogger(UsuarioController.class);

    // metodo para salvar usuario recebendo um usuarioFormDTO e um loginFormDTO
    @PostMapping
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioLogin usuarioLogin) {
        {
            log.info("Salvando usuario");
            return ResponseEntity.ok(usuarioLoginServiceImpl.salvar(usuarioLogin));

        }

    }
}