package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camino;

public interface CaminoRepository extends JpaRepository<Camino, String> {

	@Query("select c from Camino c where c.ciudadOrigen.codigoPostal =?1")
	List<Camino> findByCiudadOrigen(Integer codigoPostal);
	
	
}