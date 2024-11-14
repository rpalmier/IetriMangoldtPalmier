package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;

public interface CamionService {
    List<Camion> getAllCamiones();
    Camion saveCamion(Camion camion) throws Exception;
    Camion getCamionById(Integer id);
    Camion updateCamion(Camion camion);
    void deleteCamion(Integer id);

}