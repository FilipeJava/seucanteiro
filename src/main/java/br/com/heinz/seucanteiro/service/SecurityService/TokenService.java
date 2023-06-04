package br.com.heinz.seucanteiro.service.SecurityService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.heinz.seucanteiro.model.Credencial;
import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.model.Token;
import br.com.heinz.seucanteiro.repository.LoginRepository;
import jakarta.validation.Valid;

@Service
public class TokenService {

    @Autowired
    LoginRepository loginRepository;

    String secret = "secret";

    public Token generateToken(@Valid Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256(secret);
        
        Login user = loginRepository.findByEmail(credencial.email())
                .orElseThrow(() -> new JWTVerificationException("Usuário não encontrado"));
        
        String token = JWT.create()
                .withClaim("id", user.getId().toString())
                .withClaim("email", user.getEmail())
                .withIssuer("SeuCanteiro")
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .sign(alg);

        return new Token(token, "JWT", "Bearer ");
    }

    public Login getValidateUser(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var jwtVerifier = JWT.require(alg).withIssuer("SeuCanteiro").build();
        var jwt = jwtVerifier.verify(token);
        
        String userId = jwt.getClaim("id").asString();
        String email = jwt.getClaim("email").asString();

        Long id = Long.parseLong(userId);
        return loginRepository.findById(id)
                .orElseThrow(() -> new JWTVerificationException("Usuário não encontrado"));
    }

}
