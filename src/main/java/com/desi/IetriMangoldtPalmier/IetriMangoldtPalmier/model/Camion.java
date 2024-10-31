package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;

@Entity
@Table(name = "camion")
public class Camion {

    @Id
    @Column(name = "patente", length = 10)
    private String patente;

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "modelo")
    private Integer modelo;

    @ManyToOne
    @JoinColumn(name = "ciudad_actual")
    private Ciudad ciudadActual;

   
}
