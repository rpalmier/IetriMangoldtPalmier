package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;
import jakarta.persistence.*;

@Entity
@Table(name = "clima")
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clima")
    private Integer idClima;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    
}
