package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.DTO;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad.TipoClima;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Tramo.TipoCalzada;

public class EstadoCamino {

	private Ciudad ciudad_origen;
	private Ciudad ciudad_destino;
	private String identificador_tramo;
	private TipoCalzada tipo_calzada;
	
	public Ciudad getCiudadOrigen() {
		return ciudad_origen;
	}
	
	public void setCiudadOrigen(Ciudad _ciudad) {
		ciudad_origen = _ciudad;
	}
	
	public Ciudad getCiudadDestino() {
		return ciudad_destino;
	}
	
	public void setCiudadDestino(Ciudad _ciudad) {
		ciudad_destino = _ciudad;
	}
	
	public String getIdentificadorTramo() {
		return identificador_tramo;
	}
	
	public void setIdentificadorTramo(String _id) {
		identificador_tramo = _id;
	}
	
	public TipoCalzada getTipoCalzada() {
		return tipo_calzada;
	}
	
	public void setTipoCalzada(TipoCalzada _tipo) {
		tipo_calzada = _tipo;
	}
	
	public enum TipoEstadoCamino{
    	TRANSITABLE, INTRANSITABLE
    }
	
	public TipoEstadoCamino getEstadoCamino() {
		switch(tipo_calzada) {
			case TipoCalzada.TIERRA:
				return (ciudad_origen.getClimaActual() == TipoClima.OPTIMO && ciudad_destino.getClimaActual() == TipoClima.OPTIMO ? TipoEstadoCamino.TRANSITABLE : TipoEstadoCamino.INTRANSITABLE);
			case TipoCalzada.RIPIO:
				return (ciudad_origen.getClimaActual() == TipoClima.LLUVIA || ciudad_origen.getClimaActual() == TipoClima.OPTIMO || ciudad_destino.getClimaActual() == TipoClima.OPTIMO || ciudad_destino.getClimaActual() == TipoClima.LLUVIA ? TipoEstadoCamino.TRANSITABLE : TipoEstadoCamino.INTRANSITABLE);
				
			case TipoCalzada.ASFALTO:
				return (ciudad_origen.getClimaActual() == TipoClima.NIEVE_INTENSA || ciudad_destino.getClimaActual() == TipoClima.NIEVE_INTENSA ? TipoEstadoCamino.INTRANSITABLE:TipoEstadoCamino.TRANSITABLE);
		}
		return TipoEstadoCamino.TRANSITABLE;
	}
	
}
