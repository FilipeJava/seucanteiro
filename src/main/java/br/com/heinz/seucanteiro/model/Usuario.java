package br.com.heinz.seucanteiro.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Date dataNascimento;
    private String telefone;
    private Canteiro canteiro;

}
