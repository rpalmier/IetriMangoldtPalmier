package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "camion")
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, unique = true, nullable = false)
    private Integer id;

    @Column(name = "patente", length = 10, unique = true, nullable = false)
    @NotNull(message = "La patente es requerida.")
    private String patente;

    @Column(name = "marca", length = 50, nullable = false)
    @NotNull(message = "La marca es requerida.")
    private String marca;

    @Column(name = "modelo", nullable = false)
    @NotNull(message = "El modelo es requerido.")
    private @NotNull(message = "El modelo es requerido.") @Min(value = 1995, message = "El modelo debe ser mayor o igual a 1995.") @Max(value = 2024, message = "El modelo debe ser menor o igual a 2024.") Integer modelo;

    @ManyToOne
    @JoinColumn(name = "ciudad_actual")
    @NotNull(message = "La ciudad actual es requerida.")
    private Ciudad ciudadActual;
    

    // Constructor con todos los atributos
    public Camion(@NotNull(message = "La patente es requerida.") String patente,
                  @NotNull(message = "La marca es requerida.") String marca,
                  @NotNull(message = "El modelo es requerido.") Integer modelo,
                  @NotNull(message = "La ciudad actual es requerida.") Ciudad ciudadActual) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.ciudadActual = ciudadActual;
    }

    // Constructor vacío
    public Camion() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public @NotNull(message = "El modelo es requerido.") @Min(value = 1995, message = "El modelo debe ser mayor o igual a 1995.") @Max(value = 2024, message = "El modelo debe ser menor o igual a 2024.") Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
		 this.modelo = modelo;
    }
    
    
    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(Ciudad ciudadActual) {
		 this.ciudadActual = ciudadActual;
    }
}

