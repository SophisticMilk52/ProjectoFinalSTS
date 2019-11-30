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

import co.edu.icesi.ci.talleres.delegate.ConductorDelegate;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;
import co.edu.icesi.ci.talleres.service.ConductorService;

@Controller
public class ConductorController {

	ConductorDelegate conductorService;
	
	@Autowired
	public ConductorController(ConductorDelegate conductorService) {
		this.conductorService = conductorService;
	}
	
	@GetMapping("/conductores/")
	public String indexRuta(Model modelo) {
		modelo.addAttribute("conductores", conductorService.getConductores());
		modelo.addAttribute("conductorSearched" , new Tmio1Conductore());
		return "conductores/index";
	}
	
	@GetMapping("/conductores/add/")
	public String addConductores(Model modelo) {
		modelo.addAttribute("conductor", new Tmio1Conductore());
		return "conductores/add-conductor";
	}

	@PostMapping("/conductores/search/")
	public String searchConductor(Tmio1Conductore conductor, Model modelo) {
		try {
			Tmio1Conductore conductor1 = conductorService.getConductor(conductor.getCedula());
			modelo.addAttribute("conductores", conductor1);
		} catch(Exception s) {
			modelo.addAttribute("conductores", conductorService.getConductores());
		}
		modelo.addAttribute("conductorSearched" , new Tmio1Conductore());
		return "conductores/index";
	}

	
	@PostMapping("/conductores/add/")
	public String saveConductor(@Valid @ModelAttribute Tmio1Conductore tmio1Conductore, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String accion, Model modelo) {
		if (!accion.equals("Cancel")) {
			modelo.addAttribute("conductor", new Tmio1Conductore());
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getErrorCount());
				return "conductores/add-conductor";
			}else {
				conductorService.addConductor(tmio1Conductore);
			}
		}
		return "redirect:/conductores/";
	}
	
	@GetMapping("/conductores/del/{cedula}")
	public String borrarConductor(@PathVariable("cedula") String cedula) {
		Tmio1Conductore conductor = conductorService.getConductor(cedula);
		conductorService.delConductor(conductor);
		return "redirect:/conductores/";
	}
	
	/*
	ConductorService conductorService;
	
	@Autowired
	public ConductorController(ConductorService conductorService) {
		this.conductorService = conductorService;
	}
	
	@GetMapping("/conductores/")
	public String indexRuta(Model modelo) {
		modelo.addAttribute("conductores", conductorService.findAll());
		modelo.addAttribute("conductorSearched" , new Tmio1Conductore());
		return "conductores/index";
	}
	
	@GetMapping("/conductores/add/")
	public String addConductores(Model modelo) {
		modelo.addAttribute("conductor", new Tmio1Conductore());
		return "conductores/add-conductor";
	}

	@PostMapping("/conductores/search/")
	public String searchConductor(Tmio1Conductore conductor, Model modelo) {
		try {
			Tmio1Conductore conductor1 = conductorService.findById(conductor.getCedula());
			modelo.addAttribute("conductores", conductor1);
		} catch(Exception s) {
			modelo.addAttribute("conductores", conductorService.findAll());
		}
		modelo.addAttribute("conductorSearched" , new Tmio1Conductore());
		return "conductores/index";
	}

	
	@PostMapping("/conductores/add/")
	public String saveConductor(@Valid @ModelAttribute Tmio1Conductore tmio1Conductore, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String accion, Model modelo) {
		if (!accion.equals("Cancel")) {
			modelo.addAttribute("conductor", new Tmio1Conductore());
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getErrorCount());
				return "conductores/add-conductor";
			}else {
				conductorService.save(tmio1Conductore);
			}
		}
		return "redirect:/conductores/";
	}
	
	@GetMapping("/conductores/del/{cedula}")
	public String borrarConductor(@PathVariable("cedula") String cedula) {
		Tmio1Conductore conductor = conductorService.findById(cedula);
		conductorService.delete(conductor);
		return "redirect:/conductores/";
	}
	*/


}
