package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CamionRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.impl.CamionServiceImpl;

@Controller
public class CamionController {
	
	@Autowired
	private CamionService camionService;

	
    @GetMapping({"/camiones", "/"})
    public String viewCamionesPage(Model model) {
    	model.addAttribute("camiones", camionService.getAllCamiones());
        return "camiones";
    }
    
    @GetMapping("/camiones/nuevo")
    public String showAddCamionForm(Model model) {
    	Camion camion = new Camion();
    	model.addAttribute("camion", camion);
    	return "crear_camion";
    }
    
    @PostMapping("/camiones")
    public String saveCamion(@ModelAttribute("camion") Camion camion) {
    	camionService.saveCamion(camion);
    	return "redirect:/camiones";
    }
    
    
    @GetMapping("/camiones/editar/{id}")
    public String showUpdateCamionForm(@PathVariable Integer id, Model model) {
    	model.addAttribute("camion", camionService.getCamionById(id));
    	return "editar_camion";
    }
    
    @PostMapping("/camiones/{id}")
    public String updateCamion(@PathVariable Integer id, @ModelAttribute("camion") Camion camion, Model model) {
        Camion existingCamion = camionService.getCamionById(id);
        existingCamion.setId(id);
        existingCamion.setMarca(camion.getMarca());
        existingCamion.setModelo(camion.getModelo());
        existingCamion.setPatente(camion.getPatente());
        existingCamion.setCiudadActual(camion.getCiudadActual());
        
        camionService.updateCamion(existingCamion);
        
        return "redirect:/camiones";
    }

    @PostMapping("/camiones/delete/{id}")
    public String deleteCamion(@PathVariable Integer id) {
        camionService.deleteCamion(id);
        return "redirect:/camiones";
    }


}