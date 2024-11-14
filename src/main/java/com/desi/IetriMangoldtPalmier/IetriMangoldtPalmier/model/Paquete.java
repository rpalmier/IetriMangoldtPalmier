package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;
import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "paquete")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Integer idPaquete;

    @ManyToOne
    @JoinColumn(name = "origen", nullable = false)
    private Ciudad origen;

    @ManyToOne
    @JoinColumn(name = "destino", nullable = false)
    private Ciudad destino;

    @Column(name = "peso", precision = 5, scale = 2, nullable = false)
    private BigDecimal peso;

    @Column(name = "fragil")
    private Boolean fragil;

    @Column(name = "dni_remitente", length = 8, nullable = false)
    private String dniRemitente;

    @Column(name = "dni_destinatario", length = 8, nullable = false)
    private String dniDestinatario;

    // Getters y setters

}
