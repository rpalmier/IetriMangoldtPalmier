package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }


    public List<Ciudad> getCiudades() {
        return ciudadRepository.findAll();
    }
}
