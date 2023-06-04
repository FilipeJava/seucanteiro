package br.com.heinz.seucanteiro.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.service.SecurityService.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    Logger log = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // pegar o token header
        var token = getToken(request);
        log.info(token);

        // se for valido, autenticar
        if (token != null) {
            Login login = tokenService.getValidateUser(token);
            Authentication auth = new UsernamePasswordAuthenticationToken(login.getEmail(), null,
                    login.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);

        }

        // chamar o proximo
        filterChain.doFilter(request, response);

    }

    private String getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization"); // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
            return null;
        }
        log.info(header);
        return header.replace("Bearer ", "");
    }

}