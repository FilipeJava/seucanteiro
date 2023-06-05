package br.com.heinz.seucanteiro.model;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_INTERACAO")
public class Interacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INTERACAO")
    private Long id;

    @Column(name = "ID_CONTEXTO")
    private Long idContexto;

    @Column(name = "DS_ASSUNTO")
    private String assunto;

    @Column(name = "DT_INTERACAO")
    LocalDate dataHora;

    @ManyToOne  
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "ID_BOT")
    private Bot bot;

    @OneToMany(mappedBy = "interacao")
    private List<RespostaBot> respostas;

    @OneToMany(mappedBy = "interacao")
    private List<PerguntaUsuario> perguntas;


}