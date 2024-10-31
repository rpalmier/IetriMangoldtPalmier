package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;
import jakarta.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

  
}