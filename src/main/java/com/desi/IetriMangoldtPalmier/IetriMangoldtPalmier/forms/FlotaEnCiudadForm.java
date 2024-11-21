package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FlotaEnCiudadForm {

    @NotBlank(message = "El código postal no puede estar vacío")
    @Pattern(regexp = "\\d{4,8}", message = "El código postal debe tener entre 4 y 8 dígitos")
    private String codigoPostal;

    // Getters y setters
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}



	

	
	
	
	
	
	


