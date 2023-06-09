package br.com.heinz.seucanteiro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_RESPOSTA_BOT")
public class RespostaBot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESPOSTA_BOT")
    private long id;
    
    @Column(name = "DS_MENSAGEM")
    private String resposta;

    @Column(name = "DT_RESPOSTA")
    private LocalDate retorno;

    @ManyToOne
    @JoinColumn(name = "ID_INTERACAO")
    private Interacao interacao;

}
