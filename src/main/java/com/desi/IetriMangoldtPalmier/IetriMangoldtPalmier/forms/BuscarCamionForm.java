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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FlotaEnCiudadForm {

    @NotBlank(message = "El código postal no puede estar vacío")
    @Pattern(regexp = "\\d{4,8}", message = "El código postal debe tener 4 dígitos")
    private String codigoPostal;

    // Getters y setters
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}