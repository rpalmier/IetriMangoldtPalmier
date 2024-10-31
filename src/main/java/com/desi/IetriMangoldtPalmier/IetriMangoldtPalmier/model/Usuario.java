package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "dni", length = 8, unique = true)
    private String dni;

    // Getters y setters

    public enum TipoUsuario {
        ADMINISTRADOR,
        TRANSPORTISTA,
        OPERADOR
    }

}