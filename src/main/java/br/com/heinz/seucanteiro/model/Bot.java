package br.com.heinz.seucanteiro.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_BOT")
public class Bot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOT")
    private Long id;

    @Column(name = "DS_NOME_BOT")
    private String nome;

    @Column(name = "DS_VERSAO")
    private String descricao;

    @OneToOne(mappedBy = "bot", cascade = CascadeType.ALL)
    private Interacao interacao;

}
