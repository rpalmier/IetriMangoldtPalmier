package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms.FlotaEnCiudadForm;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/flota")
public class FlotaController {

    private final CamionService camionService;

    @Autowired
    public FlotaController(CamionService camionService) {
        this.camionService = camionService;
    }

    @GetMapping
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("formBean", new FlotaEnCiudadForm());
        return "flota_buscar";
    }

    @PostMapping
    public String buscarFlota(@ModelAttribute("formBean") @Valid FlotaEnCiudadForm formBean,
                              BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            modelo.addAttribute("formBean", formBean);
            return "flota_buscar";
        }

        try {
            List<Camion> camiones = camionService.findCamionesByCodigoPostal(formBean.getCodigoPostal());
            modelo.addAttribute("camiones", camiones);
            return "flota_buscar_resultado";
        } catch (IllegalArgumentException e) {
            result.rejectValue("codigoPostal", "error.formBean", e.getMessage());
            return "flota_buscar";
        }
    }
}

