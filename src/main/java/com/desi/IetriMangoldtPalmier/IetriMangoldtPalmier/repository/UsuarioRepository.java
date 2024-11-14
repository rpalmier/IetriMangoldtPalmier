package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}