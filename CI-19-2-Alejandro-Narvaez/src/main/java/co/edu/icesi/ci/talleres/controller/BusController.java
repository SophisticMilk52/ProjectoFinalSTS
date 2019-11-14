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

import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.service.BusService;

@Controller
public class BusController {

	BusService busService;

	@Autowired
	public BusController(BusService busService) {
		this.busService = busService;
	}

	@GetMapping("/buses/")
	public String indexBuses(Model modelo) {
		modelo.addAttribute("buses", busService.findAll());
		modelo.addAttribute("busSearched", new Tmio1Bus());
		return "buses/index";
	}

	@GetMapping("/buses/add/")
	public String addBuses(Model modelo) {
		modelo.addAttribute("bus", new Tmio1Bus());
		modelo.addAttribute("tipos", busService.getBusTypes());
		return "buses/add-bus";
	}

	@PostMapping("/buses/add/")
	public String saveBus(@Valid @ModelAttribute Tmio1Bus tmio1Bus, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String accion, Model modelo) {
		if (!accion.equals("Cancel")) {
			modelo.addAttribute("bus", new Tmio1Bus());
			if (bindingResult.hasErrors()) {
				modelo.addAttribute("tipos", busService.getBusTypes());
				return "buses/add-bus";
			} else {
				busService.save(tmio1Bus);
			}
		}
		return "redirect:/buses/";
	}

	@GetMapping("/buses/del/{id}")
	public String borrarBus(@PathVariable("id") Integer id) throws Exception {
		Tmio1Bus bus = busService.findById(id);
		busService.delete(bus);
		return "redirect:/buses/";
	}

	@PostMapping("/buses/search/")
	public String searchBus(Tmio1Bus bus, Model modelo) {
		try {
			Tmio1Bus bus1 = busService.findById(bus.getId());
			modelo.addAttribute("buses", bus1);
		} catch (Exception s) {
			modelo.addAttribute("buses", busService.findAll());
		}
		modelo.addAttribute("busSearched", new Tmio1Bus());
		return "buses/index";
	}

}
