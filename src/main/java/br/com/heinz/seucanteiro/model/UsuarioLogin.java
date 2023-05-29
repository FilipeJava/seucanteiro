package br.com.heinz.seucanteiro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLogin {

    private UsuarioFormDTO usuario;
    private LoginFormDTO login; 
    
}