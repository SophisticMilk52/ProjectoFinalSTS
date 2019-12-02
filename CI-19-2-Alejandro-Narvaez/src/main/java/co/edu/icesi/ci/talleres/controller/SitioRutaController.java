package co.edu.icesi.ci.talleres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.ci.talleres.delegate.RutaDelegate;
import co.edu.icesi.ci.talleres.delegate.SitioDelegate;
import co.edu.icesi.ci.talleres.delegate.SitiorutaDelegate;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;


@Controller
public class SitioRutaController {

	SitiorutaDelegate sitiorutaService;
	RutaDelegate rutaService;
	SitioDelegate sitioService;
	
	@Autowired
	public SitioRutaController(SitiorutaDelegate sitiorutaService, RutaDelegate rutaService, SitioDelegate sitioService) {
		this.sitiorutaService = sitiorutaService;
		this.rutaService = rutaService;
		this.sitioService = sitioService;
	}
	
	@GetMapping("/sitiosrutas/")
	public String indexSitioRuta(Model modelo) {
		modelo.addAttribute("sitiosrutas", sitiorutaService.getSitiosRutas());
		modelo.addAttribute("sitiorutaSearched", new Tmio1SitiosRuta());
		return "sitiosrutas/index";
	}
	
	@GetMapping("/sitiosrutas/add/")
	public String addSitiosRutas(Model modelo) {
		modelo.addAttribute("sitioruta", new Tmio1SitiosRuta());
		modelo.addAttribute("sitios", sitioService.getSitios());
		modelo.addAttribute("rutas", rutaService.getRutas());
		return "sitiosrutas/add-sitioruta";
	}
	
	@PostMapping("/sitiosrutas/add/")
	public String saveSitioRuta(@Valid @ModelAttribute Tmio1SitiosRuta tmio1SitioRuta, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String accion, Model modelo) {
		if (!accion.equals("Cancel")) {
			modelo.addAttribute("sitioruta", new Tmio1SitiosRuta());
			modelo.addAttribute("sitios", sitioService.getSitios());
			modelo.addAttribute("rutas", rutaService.getRutas());
			if (bindingResult.hasErrors()) {
				return "sitiosrutas/add-sitioruta";
			}else {
				//rutaService.addRuta(tmio1Ruta);
			}
		}
		return "redirect:/rutas/";
	}
	
	
}
