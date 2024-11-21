package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
	
    boolean existsByCodigoPostal(Integer codigoPostal); 
    
    Ciudad findByCodigoPostal(String codigoPostal);
    
    
}