package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CamionForm {
	
    private Integer id;

    
    @NotNull(message = "La patente es requerida.")
    private String patente;

    
    @NotNull(message = "La marca es requerida.")
    private String marca;

    
    @NotNull(message = "El modelo es requerido.")
    @Min(value = 1995, message = "El modelo debe ser mayor o igual a 1995.")
    @Max(value = 2024, message = "El modelo debe ser menor o igual a 2024.")
    private Integer modelo;

    
    @NotNull(message = "La ciudad actual es requerida.")
    private Integer idCiudad;
    
    public CamionForm(Camion c) {
    	this.id = c.getId();
        this.patente = c.getPatente();
        this.marca = c.getMarca();
        this.modelo = c.getModelo();
    }


    public CamionForm() {
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

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
		 this.modelo = modelo;
    }
    
    
    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer ciudadActual) {
		 this.idCiudad = ciudadActual;
    }
    

    public Camion toPojo() {
    	Camion c = new Camion();
    	c.setId(id);
    	c.setMarca(marca);
    	c.setModelo(modelo);
    	c.setPatente(patente);
    	return c;
    }
}
