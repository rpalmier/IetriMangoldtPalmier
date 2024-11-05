package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

<<<<<<< HEAD
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
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String modelo;

    @Column(name = "ciudad_actual", nullable = false)
    @NotNull(message = "La ciudad actual es requerida.")
    private String ciudadActual;

    // Constructor con todos los atributos
    public Camion(@NotNull(message = "La patente es requerida.") String patente,
                  @NotNull(message = "La marca es requerida.") String marca,
                  @NotNull(message = "El modelo es requerido.") String modelo,
                  @NotNull(message = "La ciudad actual es requerida.") String ciudadActual) {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
		 this.modelo = modelo;
    }
    
    
    public String getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(String ciudadActual) {
		 this.ciudadActual = ciudadActual;
    }
}

>>>>>>> branch 'agostina' of https://github.com/rpalmier/IetriMangoldtPalmier.git
