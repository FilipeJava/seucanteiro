package br.com.heinz.seucanteiro.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.model.Credencial;
import br.com.heinz.seucanteiro.service.SecurityService.TokenService;
import jakarta.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager manager;

    Logger log = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/api/v1/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        

        return ResponseEntity.ok(token);
    }

}