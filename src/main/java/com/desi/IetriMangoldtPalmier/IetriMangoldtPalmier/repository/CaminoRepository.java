package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Tramo;

public interface CaminoRepository extends JpaRepository<Tramo, Integer> {

	@Query("select c from Tramo c where c.ciudadOrigen.codigoPostal =?1")
	List<Tramo> findByCiudadOrigen(Integer codigoPostal);
	
}