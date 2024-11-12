package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.forms.CaminosVecinosForm;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camino;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CaminoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/caminos")
public class CaminoController {
	private final CaminoService caminoService;

    @Autowired
    public CaminoController(CaminoService caminoService) {
        this.caminoService = caminoService;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model modelo) {
    	CaminosVecinosForm camino = new CaminosVecinosForm();
    	modelo.addAttribute("formBean", camino);
    	return "camino";
    }
    

    @RequestMapping(method=RequestMethod.POST)
    public String obtenerCaminosVecinos( @ModelAttribute("formBean") @Valid CaminosVecinosForm  formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	if(action.equals("Buscar"))
    	{
    		if(result.hasErrors()) {
    			modelo.addAttribute("formBean",formBean);
    			return "camino";
    		}
	    	try {
	            List<Camino> caminos = caminoService.getCaminosByCiudadOrigen(formBean.getCodpost());
	            modelo.addAttribute("caminos", caminos);
	            return "camino";
	        } catch (IllegalArgumentException e) {;
		        ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
	        }
    	}
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/caminos";
    	}
        return "camino";                   
    }
    
    
}
