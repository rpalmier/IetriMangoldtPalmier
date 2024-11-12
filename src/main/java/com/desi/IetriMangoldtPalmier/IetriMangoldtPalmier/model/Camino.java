package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;

@Entity
@Table(name = "camino")
public class Camino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    	return id;
    }
    
    public void setId (Integer _id) {
    	id = _id;
    }
    
    public Ciudad getCiudadOrigen() {
    	return ciudadOrigen;
    }
    
    public void setCiudadOrigen(Ciudad _ciudadOrigen) {
    	ciudadOrigen = _ciudadOrigen;
    }
    
    public Ciudad getCiudadDestino() {
    	return ciudadDestino ;
    }
    
    public void setCiudadDestino(Ciudad _ciudadDestino) {
    	ciudadDestino = _ciudadDestino;
    }

    public String getEstadoCamino() {
    	return estadoCamino ;
    }
    
    public void setEstadoCamino(String _estadoCamino) {
    	estadoCamino = _estadoCamino;
    }
    
    public String getEstadoClima() {
    	return estadoClima ;
    }
    
    public void setEstadoClima(String _estadoClima) {
    	estadoClima = _estadoClima;
    }
    
   }

