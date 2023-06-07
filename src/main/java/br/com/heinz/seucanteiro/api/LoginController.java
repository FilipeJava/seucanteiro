package br.com.heinz.seucanteiro.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.dto.form.LoginFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.LoginRespostaDTO;
import br.com.heinz.seucanteiro.model.Credencial;
import br.com.heinz.seucanteiro.service.SecurityService.TokenService;
import br.com.heinz.seucanteiro.service.serviceImpl.LoginServiceImpl;
import jakarta.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    TokenService tokenService;

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    AuthenticationManager manager;

    Logger log = LoggerFactory.getLogger(LoginController.class);

    // metodo de autenticacao
    @PostMapping("/api/v1/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);

        return ResponseEntity.ok(token);
    }

    // metodo para atualizar login isoladamente
    @PutMapping("/api/v1/login/{id}")
    public ResponseEntity<LoginRespostaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid LoginFormDTO login) {
        log.info("Atualizando login");
        return ResponseEntity.ok(loginServiceImpl.atualizaLogin(id, login));
    }

}