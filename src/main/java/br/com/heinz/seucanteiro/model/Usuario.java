package br.com.heinz.seucanteiro.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.type.TrueFalseConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO")
    private String nome;

    @Column(name = "DS_CPF")
    private String cpf;

    @Column(name = "DT_NASCIMENTO")
    private LocalDateTime dataNascimento;

    @Column(name = "DS_TELEFONE")
    private String telefone;

    // relacao 1 : N
    @OneToMany(mappedBy = "usuario")
    private List<Canteiro> canteiros;

    // relacao N : 1
    @ManyToOne
    @JoinColumn(name = "ID_LOGIN", nullable = true)
    private Login login;

} 
