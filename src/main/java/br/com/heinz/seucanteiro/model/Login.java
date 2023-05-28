package br.com.heinz.seucanteiro.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity(name = "T_CAN_LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOGIN")
    private Long id;

    @Column(name = "DS_EMAIL")
    @NotBlank
    @Email
    private String email;

    @Column(name = "DS_SENHA")
    @NotBlank @Size(min = 8, max = 16)
    private String senha;

    // relacao 1 : N
    @OneToMany(mappedBy = "login")
    private List<Usuario> usuario;



    


}
