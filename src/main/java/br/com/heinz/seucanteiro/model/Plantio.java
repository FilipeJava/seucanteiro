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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CAN_PLANTIO")
public class Plantio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLANTIO")
    private Long id;

    @Column(name = "QT_PLANTADA")
    private Integer quantidadePlantada;

    @Column(name = "DT_PLANTIO")
    private LocalDate dataPlantio;

    @Column(name = "DT_COLHEITA")
    private LocalDate dataColheita;

    // relacao N : 1
    @ManyToOne
    @JoinColumn(name = "ID_CANTEIRO", nullable = true)
    private Canteiro canteiro;

    // relacao N : 1
    @ManyToOne
    @JoinColumn(name = "ID_PLANTA", nullable = true)
    private Planta planta;

}
