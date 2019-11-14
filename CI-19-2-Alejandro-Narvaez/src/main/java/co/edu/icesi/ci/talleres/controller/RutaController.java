package co.edu.icesi.ci.talleres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.ci.talleres.dao.DAORuta;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;
import co.edu.icesi.ci.talleres.service.RutaService;

@Controller
public class RutaController {

	DAORuta rutaService;
	
	@Autowired
	public RutaController(DAORuta rutaService) {
		this.rutaService = rutaService;
	}
	
	@GetMapping("/rutas/")
	public String indexRuta(Model modelo) {
		modelo.addAttribute("rutas", rutaService.findAll());
		modelo.addAttribute("rutaSearched", new Tmio1Ruta());
		return "rutas/index";
	}
	
	@GetMapping("/rutas/add/")
	public String addRutas(Model modelo) {
		modelo.addAttribute("ruta", new Tmio1Ruta());
		return "rutas/add-ruta";
	}

	public String buscarRuta(Tmio1Ruta ruta, Model modelo) {
		return "";
	}
	
	@GetMapping("/rutas/del/{id}")
	public String borrarRuta(@PathVariable("id") Integer id) {
		Tmio1Ruta ruta = rutaService.findById(id);
		rutaService.delete(ruta);
		return "redirect:/rutas/";
	}
	
	@PostMapping("/rutas/search/")
	public String searchRuta(Tmio1Ruta ruta, Model modelo) {
		try {
			Tmio1Ruta ruta1 = rutaService.findById(ruta.getId());
			modelo.addAttribute("rutas", ruta1);
		} catch(Exception s) {
			modelo.addAttribute("rutas", rutaService.findAll());
		}
		modelo.addAttribute("rutaSearched" , new Tmio1Ruta());
		return "rutas/index";
	}
	
	@PostMapping("/rutas/add/")
	public String saveRuta(@Valid @ModelAttribute Tmio1Ruta tmio1Ruta, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String accion, Model modelo) {
		if (!accion.equals("Cancel")) {
			modelo.addAttribute("ruta", new Tmio1Ruta());
			if (bindingResult.hasErrors()) {
				return "rutas/add-ruta";
			}else {
				rutaService.save(tmio1Ruta);
			}
		}
		return "redirect:/rutas/";
	}
	

}
