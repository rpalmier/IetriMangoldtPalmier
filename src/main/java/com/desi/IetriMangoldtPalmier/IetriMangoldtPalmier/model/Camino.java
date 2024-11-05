package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;

@Entity
@Table(name = "camino")
public class Camino {

    @Id
    @Column(name = "id", length = 10)
    private Integer id;

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
    
    public Integer getId() {
    	return this.id;
    }
    public void setId(Integer _id) {
    	this.id = _id;
    }
    
    public Ciudad getCiudadDestino() {
    	return this.ciudadDestino;
    }
    public void setCiudadDestino(Ciudad _ciudad) {
    	this.ciudadDestino = _ciudad;
    }
    
    public Ciudad getCiudadOrigen() {
    	return this.ciudadOrigen;
    }
    public void setCiudadOrigen(Ciudad _ciudad) {
    	this.ciudadOrigen = _ciudad;
    }
    
    public String getEstadoCamino() {
    	return this.estadoCamino;
    }
    public void setEstadoCamino(String _estadoCamino) {
    	this.estadoCamino = _estadoCamino;
    }
    public String getEstadoClima() {
    	return this.estadoClima;
    }
    public void setEstadoClima(String _estadoClima) {
    	this.estadoClima = _estadoClima;
    }

   }

