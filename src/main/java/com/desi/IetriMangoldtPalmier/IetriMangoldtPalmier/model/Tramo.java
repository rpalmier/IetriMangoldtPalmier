package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;

import jakarta.persistence.*;

@Entity
@Table(name = "camino")
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Integer id;
    
    @Column(name = "identificador", length = 10)
    private String identificador;
    
    public enum TipoCalzada{
    	TIERRA, RIPIO, ASFALTO
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_calzada", length = 10)
    private TipoCalzada tipo_calzada;

    @ManyToOne
    @JoinColumn(name = "ciudad_origen")
    private Ciudad ciudadOrigen;

    @ManyToOne
    @JoinColumn(name = "ciudad_destino")
    private Ciudad ciudadDestino;
    
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

    public String getIdentificador() {
    	return identificador;
    }
    
    public void setIdentificador(String _identificador) {
    	identificador = _identificador;
    }
    
    public TipoCalzada getTipoCalzada() {
    	return tipo_calzada;
    }
    
    public void setTipoCalzada(TipoCalzada _tipo) {
    	tipo_calzada = _tipo;
    }
    
   }

