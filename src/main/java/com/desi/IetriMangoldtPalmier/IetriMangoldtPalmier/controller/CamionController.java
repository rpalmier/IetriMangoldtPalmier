package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms.CamionForm;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Ciudad;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CamionService;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CiudadService;

@Controller
public class CamionController {
	
	@Autowired
	private CamionService camionService;
	
	@Autowired
	private CiudadService ciudadService;

	
    @GetMapping({"/camiones", "/"})
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
    public String saveCamion(@ModelAttribute("camion") CamionForm camion,BindingResult result, Model model) {
    	if(result.hasErrors()) {
        	model.addAttribute("camion", camion);
        	return "editar_camion";
        }
    	Camion modelCamion =  camion.toPojo();
    	modelCamion.setCiudadActual(ciudadService.getCiudadById(camion.getIdCiudad()) );
    	camionService.saveCamion(modelCamion);
    	return "redirect:/camiones";
    }
    
    
    @GetMapping("/camiones/editar/{id}")
    public String showUpdateCamionForm(@PathVariable Integer id, Model model) {
    	model.addAttribute("camion",new CamionForm(camionService.getCamionById(id)));
    	return "editar_camion";
    }
    
    @PostMapping("/camiones/{id}")
    public String updateCamion(@PathVariable Integer id, @ModelAttribute("camion") CamionForm camion,BindingResult result, Model model) {
        if(result.hasErrors()) {
        	model.addAttribute("camion", model);
        	return "editar_camion";
        }
    	Camion existingCamion =  camion.toPojo();
        
        existingCamion.setCiudadActual(ciudadService.getCiudadById(camion.getIdCiudad()) );
        
        camionService.updateCamion(existingCamion);
        
        return "redirect:/camiones";
    }

    @GetMapping("/camiones/delete/{id}")
    public String deleteCamion(@PathVariable Integer id) {
        camionService.deleteCamion(id);
        return "redirect:/camiones";
    }


}