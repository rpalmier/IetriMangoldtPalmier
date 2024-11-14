package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camino;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.EstadoCaminoRepository;

public interface CaminoService {
	List<Camino> getCaminosByCiudadOrigen(Integer codigoPostal); 
}
