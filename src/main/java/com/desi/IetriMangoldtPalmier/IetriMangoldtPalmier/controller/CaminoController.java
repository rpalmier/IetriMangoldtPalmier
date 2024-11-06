package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.controller;

import org.springframework.web.bind.annotation.RequestMapping;

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
