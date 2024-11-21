package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service;

import java.util.List;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;

public interface CiudadService {
    Ciudad getCiudadById(Integer _id);
    List<Ciudad> getCiudades();
    
    Ciudad getCiudadByCodigoPostal(String codigoPostal);
    
    String getEstadoClima(String codigoPostal);
}
