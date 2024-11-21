package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.DTO.EstadoCamino;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Tramo;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;

public interface CaminoService {
	List<EstadoCamino> getCaminosByCiudadOrigen(Integer codigoPostal); 
}
