package br.com.heinz.seucanteiro.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank @Size(min = 8, max = 16)
    private String senha;

   
    
}