package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;

@Entity
@Table(name = "camino")
public class Camino {

    @Id
    @Column(name = "id_camino", length = 10)
    private Integer idCamino;

    @ManyToOne
    @JoinColumn(name = "ciudad_origen")
    private Ciudad ciudadOrigen;

    @ManyToOne
    @JoinColumn(name = "ciudad_destino")
    private Ciudad ciudadDestino;

    @Column(name = "estado_camino", length = 50)
    private String estadoCamino;

    @Column(name = "estado_clima", length = 50)
    private String estadoClima;

   }

