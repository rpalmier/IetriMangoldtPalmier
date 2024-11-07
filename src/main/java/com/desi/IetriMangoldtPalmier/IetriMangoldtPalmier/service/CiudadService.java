package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CiudadRepository;


public interface CiudadService {
    Ciudad getCiudadById(Integer _id);
    List<Ciudad> getCiudades();
}
