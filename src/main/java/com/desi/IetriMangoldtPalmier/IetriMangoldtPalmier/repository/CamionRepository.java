package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;

public interface CamionRepository extends JpaRepository<Camion, String> {
=======
import org.springframework.stereotype.Repository;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Integer> {
>>>>>>> branch 'agostina' of https://github.com/rpalmier/IetriMangoldtPalmier.git

}
