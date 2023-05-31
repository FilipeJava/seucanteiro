package br.com.heinz.seucanteiro.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "T_CAN_PLANTAS")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLANTA")
    private Long id;

    @Column(name = "NM_PLANTA")
    @NotBlank
    @Size(min = 3)
    private String nome;

    @Column(name = "NR_REGACAO")
    @NotNull
    private Integer regacao;

    @Column(name = "NM_CIENTIFICO")
    private String nomeCientifico;

    @Column(name = "NM_APELIDO")
    private String apelido;

    // relacao 1 : N
    @OneToMany(mappedBy = "planta")
    private List<Plantio> plantios;

}