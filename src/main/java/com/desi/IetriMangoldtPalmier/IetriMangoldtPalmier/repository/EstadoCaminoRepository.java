package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.EstadoCamino;

public interface EstadoCaminoRepository extends JpaRepository<EstadoCamino, Integer> {

}