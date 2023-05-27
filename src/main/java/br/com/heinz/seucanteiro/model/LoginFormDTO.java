package br.com.heinz.seucanteiro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormDTO {

    //*Deve se fazer as validations aqui tbm */


    /*Dados que o usuario enviar via Post do controler */
    private String email;

    private String senha;

   
    
}