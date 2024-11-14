package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camino;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.EstadoCaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CaminoService;

@Service
public class CaminoServiceImpl implements CaminoService {

	@Autowired
	private CaminoRepository caminoRepository;
	@Autowired
	private CiudadRepository ciudadRepository;

	

	public List<Camino> getCaminosByCiudadOrigen(Integer codigoPostal) {
	        if (codigoPostal == null) {
	            throw new IllegalArgumentException("El código postal es obligatorio.");
	        }

	        boolean ciudadExiste = ciudadRepository.existsByCodigoPostal(codigoPostal);
	        if (!ciudadExiste) {
	            throw new IllegalArgumentException("La ciudad con el código postal proporcionado no está registrada.");
	        }

	        return caminoRepository.findByCiudadOrigen(codigoPostal);
	}
}
