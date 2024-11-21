package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Integer> {
	
	public List<Camion> getCamionByPatente(String patente);

    Camion findByPatente(String patente);
    
    List<Camion> findByCiudadCodigoPostal(String codigoPostal);

}
