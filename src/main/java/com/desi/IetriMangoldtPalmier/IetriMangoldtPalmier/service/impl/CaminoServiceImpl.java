package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.DTO.EstadoCamino;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Tramo;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CaminoService;

@Service
public class CaminoServiceImpl implements CaminoService {

	@Autowired
	private CaminoRepository caminoRepository;
	@Autowired
	private CiudadRepository ciudadRepository;

	

	public List<EstadoCamino> getCaminosByCiudadOrigen(Integer codigoPostal) {
	        if (codigoPostal == null) {
	            throw new IllegalArgumentException("El código postal es obligatorio.");
	        }

	        boolean ciudadExiste = ciudadRepository.existsByCodigoPostal(codigoPostal);
	        if (!ciudadExiste) {
	            throw new IllegalArgumentException("La ciudad con el código postal proporcionado no está registrada.");
	        }

	        List<Tramo> _tramos = caminoRepository.findByCiudadOrigen(codigoPostal);
	        
	        // Hago esto porque no se como hacer para que desde la consulta se cree el objeto List<EstadoCamino>
	        List<EstadoCamino> _estados = new ArrayList<>();
	        for(Tramo _tramo:_tramos) {
	        	EstadoCamino _estado = new EstadoCamino();
	        	_estado.setCiudadOrigen(_tramo.getCiudadOrigen());
	        	_estado.setCiudadDestino(_tramo.getCiudadDestino());
	        	_estado.setIdentificadorTramo(_tramo.getIdentificador());
	        	_estado.setTipoCalzada(_tramo.getTipoCalzada());
	        	_estados.add(_estado);
	        }
	        
	        // Fin codigo feo
	        return _estados;
	}
}
