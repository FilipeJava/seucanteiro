package br.com.heinz.seucanteiro.dto.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    @Email
    private String email;

    @NotBlank 
    private String senha;

   
    
}