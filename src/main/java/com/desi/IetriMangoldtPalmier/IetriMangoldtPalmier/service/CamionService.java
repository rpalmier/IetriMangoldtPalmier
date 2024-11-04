package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;

//@Service
public interface CamionService {

    List<Camion> getAllCamiones();
    Camion saveCamion(Camion camion);

    Camion getCamionById(Integer id);
    Camion updateCamion(Camion camion);
    void deleteCamion(Integer id);
}
