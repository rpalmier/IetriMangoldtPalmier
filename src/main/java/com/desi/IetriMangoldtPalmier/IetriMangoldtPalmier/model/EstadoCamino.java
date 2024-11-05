package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;
import jakarta.persistence.*;

@Entity
@Table(name = "estadocamino")
public class EstadoCamino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @ManyToOne
    @JoinColumn(name = "id_camino", nullable = false)
    private Camino camino;

    @Column(name = "estadoCamino", length = 50)
    private String estadoCamino;

    @Column(name = "estadoClima", length = 50)
    private String estadoClima;

   
}