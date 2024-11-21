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

