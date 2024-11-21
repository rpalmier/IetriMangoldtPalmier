package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms;

import jakarta.validation.constraints.NotNull;

public class CaminosVecinosForm {

    
    @NotNull(message = "Debe ingresar un código postal")
    private Integer codpost;

    public Integer getCodpost() {
    	return codpost;
    }
    
    public void setCodpost(Integer _codpost) {
    	codpost  = _codpost;
    }
    
    
}
