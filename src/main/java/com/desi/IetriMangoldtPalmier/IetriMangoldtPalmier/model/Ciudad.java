package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Tramo.TipoCalzada;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "codigo_postal", unique = true, nullable = false)
    private Integer codigoPostal;

    @Column(name = "nombre", length = 100, nullable = false)
    @NotNull(message = "El nombre de la ciudad es requerido")
    private String nombre;
    
    public enum TipoClima{
    	OPTIMO, LLUVIA, NIEVE_INTENSA, TORMENTOSO
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "clima_actual", length = 20)
    private TipoClima clima_actual;
    
    public Integer getId() {
    	return id;
    }
    
    public void setId(Integer _id) 
    {
    	this.id = _id;
    }
    
    public Integer getCodigoPostal() {
    	return codigoPostal;
    }
   
    public void setCodigoPostal(Integer codigoPostal) {
    	this.codigoPostal = codigoPostal;
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public TipoClima getClimaActual(){
    	return clima_actual;
    }
    
    public void setClimaActuaal(TipoClima _climaActual) {
    	clima_actual = _climaActual;
    }
    
    @Override
    public String toString() {
        return codigoPostal +
               " - " + nombre;
    }
}
