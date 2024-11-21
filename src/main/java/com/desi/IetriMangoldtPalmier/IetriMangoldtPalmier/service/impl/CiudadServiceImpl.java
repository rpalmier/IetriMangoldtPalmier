package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }
    
    
    public Ciudad getCiudadById(Integer _id) {
    	Optional<Ciudad> c =ciudadRepository.findById(_id);
    	if(!c.isPresent()) {
    		return new Ciudad(); 
    	}
    	return c.get();
    }

    public List<Ciudad> getCiudades() {
        return ciudadRepository.findAll();
    }
}
