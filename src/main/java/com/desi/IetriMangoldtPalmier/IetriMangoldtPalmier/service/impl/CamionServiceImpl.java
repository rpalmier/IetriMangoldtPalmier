package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl;

import java.util.List;

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
	public Camion saveCamion(Camion camion) {
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
