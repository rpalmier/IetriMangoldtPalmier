package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CamionRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;

@Service
public class CamionServiceImpl implements CamionService {
	
    @Autowired
    private CamionRepository camionRepository;

    @Override
    public List<Camion> getAllCamiones() {
        return camionRepository.findAll();
    }

    @Override
    public Camion saveCamion(Camion camion) throws IllegalArgumentException {
        System.out.println("Verificando patente: " + camion.getPatente());
        Optional<Camion> existingCamion = camionRepository.findByPatente(camion.getPatente());
        System.out.println("Camión existente encontrado: " + existingCamion.isPresent());

        if (existingCamion.isPresent() && (camion.getId() == null || !existingCamion.get().getId().equals(camion.getId()))) {
            throw new IllegalArgumentException("Ya existe un camión con la misma patente.");
        }

        return camionRepository.save(camion);
    }


	@Override
	public Camion getCamionById(Integer id) {
		return camionRepository.findById(id).get();
	}

	@Override
	public Camion updateCamion(Camion camion) {
		return camionRepository.save(camion);
	}

	@Override
	public void deleteCamion(Integer id) {
		camionRepository.deleteById(id);
		
	}

	/*
	@Override
	public void save(Camion camion) {
		camionRepository.save(camion);
		
	}*/

}
