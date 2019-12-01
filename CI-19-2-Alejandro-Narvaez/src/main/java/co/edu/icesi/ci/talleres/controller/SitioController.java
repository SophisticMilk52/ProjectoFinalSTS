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

import co.edu.icesi.ci.talleres.delegate.SitioDelegate;
import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

@Controller
public class SitioController {

	SitioDelegate sitioService;
	
	@Autowired
	public SitioController(SitioDelegate sitioService) {
		this.sitioService = sitioService;
	}
	
	@GetMapping("/sitios/")
	public String indexSitio(Model modelo) {
		modelo.addAttribute("sitios", sitioService.getSitios());
		modelo.addAttribute("sitioSearched", new Tmio1Sitio());
		return "sitios/index";
	}
	
	@GetMapping("/sitios/add/")
	public String addSitios(Model modelo) {
		modelo.addAttribute("sitio", new Tmio1Sitio());
		return "sitios/add-sitio";
	}
	
	@GetMapping("/sitios/del/{id}")
	public String borrarSitio(@PathVariable("id") Long id) {
		Tmio1Sitio sitio = sitioService.getSitio(id);
		sitioService.delSitio(sitio);
		return "redirect:/sitios/";
	}
	
	@PostMapping("/sitios/search/")
	public String searchSitio(Tmio1Sitio sitio, Model modelo) {
		try {
			Tmio1Sitio sitio1 = sitioService.getSitio(sitio.getId());
			modelo.addAttribute("sitios", sitio1);
		} catch(Exception s) {
			modelo.addAttribute("sitios", sitioService.getSitios());
		}
		modelo.addAttribute("sitioSearched" , new Tmio1Sitio());
		return "sitios/index";
	}
	
	@PostMapping("/sitios/add/")
	public String saveSitio(@Valid @ModelAttribute Tmio1Sitio tmio1Sitio, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String accion, Model modelo) {
		if (!accion.equals("Cancel")) {
			modelo.addAttribute("sitio", new Tmio1Sitio());
			if (bindingResult.hasErrors()) {
				return "sitios/add-sitio";
			}else {
				sitioService.addSitio(tmio1Sitio);
			}
		}
		return "redirect:/sitios/";
	}
}
