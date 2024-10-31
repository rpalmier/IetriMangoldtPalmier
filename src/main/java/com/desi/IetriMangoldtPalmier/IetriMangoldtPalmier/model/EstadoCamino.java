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

    @Column(name = "estado_camino", length = 50)
    private String estadoCamino;

    @Column(name = "estado_clima", length = 50)
    private String estadoClima;

   
}