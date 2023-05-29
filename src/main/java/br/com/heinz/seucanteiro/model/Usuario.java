package br.com.heinz.seucanteiro.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO")
    @NotBlank
    @Size(min = 3)
    private String nome;

    @Column(name = "DS_CPF")
    @NotBlank
    private String cpf;

    @Column(name = "DT_NASCIMENTO")
    @NotNull
    private LocalDate dataNascimento;

    @Column(name = "DS_TELEFONE")
    @NotBlank
    private String telefone;

    // relacao 1 : N
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Canteiro> canteiros;

    // relacao N : 1
    @ManyToOne( )
    @JoinColumn(name = "ID_LOGIN")
    private Login login;

    public void addCanteiro(Canteiro canteiro) {
        this.canteiros.add(canteiro);
    }
}
