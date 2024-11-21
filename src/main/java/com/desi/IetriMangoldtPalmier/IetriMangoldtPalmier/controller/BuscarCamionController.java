package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms.BuscarCamionForm;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/buscarCamion")
public class BuscarCamionController {

    private final CamionService camionService;

    @Autowired
    public BuscarCamionController(CamionService camionService) {
        this.camionService = camionService;
    }

    @GetMapping
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("formBean", new BuscarCamionForm());
        return "camion_buscar";
    }

    @PostMapping
    public String buscarCamion(@ModelAttribute("formBean") @Valid BuscarCamionForm formBean,
                               BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            modelo.addAttribute("formBean", formBean);
            return "camion_buscar";
        }

        try {
            Camion camion = camionService.getCamionPorPatente(formBean.getPatente());
            modelo.addAttribute("camion", camion);
            return "camion_buscar_resultado";
        } catch (IllegalArgumentException e) {
            result.rejectValue("patente", "error.formBean", e.getMessage());
            return "camion_buscar";
        }
    }
}


/*
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms.BuscarCamionForm;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;

@Controller
@RequestMapping("/camion")
public class BuscarCamionController {

    @GetMapping("/buscar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("buscarCamionForm", new BuscarCamionForm());
        return "camion_buscar"; // Ahora busca en la carpeta templates/camion_buscar.html
    }

    @PostMapping("/buscar")
    public String buscarCamion(@ModelAttribute BuscarCamionForm buscarCamionForm, Model model) {
        CamionService camionService = null;
        
		// lógica de servicio para obtener la información del camión
        Camion camion = camionService.findCamionByPatente(buscarCamionForm.getPatente());
        if (camion != null) {
            model.addAttribute("patente", camion.getPatente());
            model.addAttribute("codigoPostal", camion.getCiudadActual().getCodigoPostal());
            model.addAttribute("ciudad", camion.getCiudadActual().getNombre());
   //       model.addAttribute("clima", camion.getCiudadActual().getClima().getEstado()); 
        } else {
            model.addAttribute("error", "No se encontró el camión con la patente proporcionada.");
        }
        return "camion_buscar";
    }
}
*/



