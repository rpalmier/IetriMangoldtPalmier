package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms.CamionForm;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CamionRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CiudadService;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl.CamionServiceImpl;

import jakarta.validation.Valid;

@Controller
public class CamionController {
	
	@Autowired
	private CamionService camionService;
	
	@Autowired
	private CiudadService ciudadService;

	
    @GetMapping({"/camiones"})
    public String viewCamionesPage(Model model) {
    	model.addAttribute("camiones", camionService.getAllCamiones());
        return "camiones";
    }
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades(){
    	return this.ciudadService.getCiudades();
    }
    
    @GetMapping("/camiones/nuevo")
    public String showAddCamionForm(Model model) {
    	model.addAttribute("camion", new CamionForm());
    	return "crear_camion";
    }
    
    @PostMapping("/camiones")
    public String saveCamion(@ModelAttribute("camion") @Valid CamionForm camion, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            model.addAttribute("camion", camion);
            return "crear_camion";
        }

        Camion modelCamion = camion.toPojo();
        modelCamion.setCiudadActual(ciudadService.getCiudadById(camion.getIdCiudad()));

        try {
            camionService.saveCamion(modelCamion);
        } catch (IllegalArgumentException e) {
            result.rejectValue("patente", "error.patente", "Ya existe un camión con la misma patente.");
            
            result.rejectValue("modelo", "error.modelo", "El modelo debe ser mayor o igual a 1995 y menor o igual a 2024.");
            
            model.addAttribute("camion", camion);
            return "crear_camion";
        }

        return "redirect:/camiones";
    }
    
    
    @GetMapping("/camiones/editar/{id}")
    public String showUpdateCamionForm(@PathVariable Integer id, Model model) {
    	model.addAttribute("camion",new CamionForm(camionService.getCamionById(id)));
    	return "editar_camion";
    }
    
    @PostMapping("/camiones/{id}")
    public String updateCamion(@PathVariable Integer id, @ModelAttribute("camion") @Valid CamionForm camion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("camion", camion);
            return "editar_camion";
        }
        
        Camion existingCamion = camion.toPojo();
        existingCamion.setId(id);
        existingCamion.setCiudadActual(ciudadService.getCiudadById(camion.getIdCiudad()));

        try {
            camionService.updateCamion(existingCamion);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "La patente ya está registrada.");
            model.addAttribute("camion", camion);
            return "editar_camion";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error desconocido. Por favor intentá de nuevo.");
            model.addAttribute("camion", camion);
            return "editar_camion";
        }

        return "redirect:/camiones";
    }

    @GetMapping("/camiones/delete/{id}")
    public String deleteCamion(@PathVariable Integer id) {
        camionService.deleteCamion(id);
        return "redirect:/camiones";
    }


}