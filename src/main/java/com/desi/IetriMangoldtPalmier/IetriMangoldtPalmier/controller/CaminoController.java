package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camino;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CaminoRepository;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.service.CaminioService;

@Controller
@RequestMapping("/caminos")
public class CaminoController {
	private final CaminioService caminoService;

    @Autowired
    public CaminoController(CaminioService caminoService) {
        this.caminoService = caminoService;
    }
    
    @GetMapping("/")
    public String index() {
    	return "camino";
    }
    

    @GetMapping("/vecinos")
    public String obtenerCaminosVecinos(@RequestParam Integer codigoPostal, ModelMap modelo) {
        try {
            List<Camino> caminos = caminoService.getCaminosByCiudadOrigen(codigoPostal);
            modelo.addAttribute("caminos", caminos);
            return "camino";
        } catch (IllegalArgumentException e) {;
        	
        }
        return "camino";                   
    }
}
