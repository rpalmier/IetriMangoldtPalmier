package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms;

import jakarta.validation.constraints.NotBlank;

public class BuscarCamionForm {

    @NotBlank(message = "La patente no puede estar vacía")
    private String patente;

    // Getters y setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}