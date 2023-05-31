package br.com.heinz.seucanteiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
.allowedOrigins("*") // Altere "*" para o domínio que você deseja permitir
.allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
.allowedHeaders("*") // Headers permitidos
.allowCredentials(false); // Habilita o uso de cookies na requisição (senecessário)
}
}
