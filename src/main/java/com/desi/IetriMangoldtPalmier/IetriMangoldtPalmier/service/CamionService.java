package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;

public interface CamionService {
    List<Camion> getAllCamiones();
    Camion saveCamion(Camion camion);
    Camion getCamionById(Integer id);
    Camion updateCamion(Camion camion);
    void deleteCamion(Integer id);
    
    List<Camion> findCamionesByCodigoPostal(String codigoPostal);

    Camion getCamionPorPatente(String patente);
  
    
}