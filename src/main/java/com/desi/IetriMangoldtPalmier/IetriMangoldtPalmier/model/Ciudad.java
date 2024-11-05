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

    public Integer getCodigoPostal() {
    	return this.codigoPostal;
    }
    public void setCodigoPostal(Integer _codigoPostal) {
    	this.codigoPostal = _codigoPostal;
    }
    
    public String getNombre() {
    	return this.nombre;
    }
    public void setNombre(String _nombre) {
    	this.nombre = _nombre;
    }
    
    @Override
    public String toString() {
    	return this.codigoPostal.toString() +" - " + this.nombre;
    }
    
}