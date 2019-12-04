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

import co.edu.icesi.ci.talleres.delegate.RutaDelegate;
import co.edu.icesi.ci.talleres.delegate.SitioDelegate;
import co.edu.icesi.ci.talleres.delegate.SitiorutaDelegate;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;
import co.edu.icesi.ci.talleres.service.InterfazRutaService;
import co.edu.icesi.ci.talleres.service.InterfazSitioRutaService;
import co.edu.icesi.ci.talleres.service.InterfazSitioService;

@Controller
public class SitioRutaController {

	@Autowired
	private InterfazRutaService rutaService;
	@Autowired
	private InterfazSitioService sitioService;

	@Autowired
	private InterfazSitioRutaService sitioRutaService;
	
	@GetMapping("/admin/add/sitio-ruta")
	public String addSitio(Model model) {
		Tmio1SitiosRutaPK sitioRutaPK = new Tmio1SitiosRutaPK();
		model.addAttribute("sitiorutaPK", sitioRutaPK);
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("sitios", sitioService.findAll());
		
		return "add/addsitioruta";
	}
	
	@PostMapping("/admin/add/sitio-ruta")
	public String saveSitioRuta(@Valid Tmio1SitiosRutaPK sitioRutaPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		Tmio1SitiosRuta sitioRuta = new Tmio1SitiosRuta();
		sitioRuta.setId(sitioRutaPK);
		sitioRuta.setTmio1Ruta1(rutaService.findById(sitioRutaPK.getIdRuta()));
		sitioRuta.setTmio1Sitio1(sitioService.findById((long)sitioRutaPK.getIdSitio()));
		sitioRutaPK.setHash(sitioRuta.hashCode());
		
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("sitiorutaPK", sitioRutaPK);
				model.addAttribute("rutas", rutaService.findAll());
				model.addAttribute("sitios", sitioService.findAll());
				return "add/addsitioruta";
			}
			
		}
		if (action.equals("Cancel")) {
			return "redirect:/app/sitios-ruta";
		}
		try {
			sitioRutaService.save(sitioRuta);
			System.out.println("Sitio-ruta added >> "+sitioRuta.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/app/sitios-ruta";
	}
	
	@GetMapping("/app/sitios-ruta")
	public String indexSitiosRuta(Model model) {
		model.addAttribute("sitiosrutas", sitioRutaService.findAll());
		return "search/sitiosrutas";
	}
	
	@GetMapping("/app/search/sitio-ruta/{id}")
	public String showInfoForm(@PathVariable("id") int id, Model model) {
		Tmio1SitiosRuta sitioruta = sitioRutaService.findByHashCode(id);
		if (sitioruta == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("sitiorutaPK", sitioruta.getId());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("sitios", sitioService.findAll());
		model.addAttribute("sitioruta", sitioruta);
		return "search/sitioruta";
	}
	
	@PostMapping("/admin/update/sitio-ruta")
	public String showUpdateForm(@Valid Tmio1SitiosRuta sitioruta, Model model,
			@RequestParam(value = "action", required = true) String action) {
//		Tmio1SitiosRuta sitioruta = sitioRutaService.findByHashCode(id);
		System.out.println(sitioruta.getId().hashCode()+">>>>");
		if (sitioruta == null)
			throw new IllegalArgumentException("Invalid user Id:" );
		
		if(action.equals("Cancel")) {
			return "redirect:/app/sitios-ruta";
		}
		System.out.println(sitioruta.getId().hashCode());
		model.addAttribute("hash", sitioruta.getId().hashCode());
		model.addAttribute("sitiorutaPK", sitioruta.getId());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("sitios", sitioService.findAll());
		model.addAttribute("sitioruta", sitioruta);
		return "update/updatesitioruta";
	}
	
	@PostMapping("/admin/update/sitio-ruta1")
	public String update(Model model, Tmio1SitiosRutaPK sitioRutaPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action) {
		
		if (action.equals("Cancel")) {
			
			return "redirect:/app/sitios-ruta";
		}
		System.out.println(sitioRutaPK.hashCode());
		Tmio1SitiosRuta sitioRuta = sitioRutaService.findByHashCode(sitioRutaPK.hashCode());
		System.out.println(sitioRuta+" >>>> to delete");
		try {
			sitioRutaService.delete(sitioRuta);
			sitioRutaPK.setIdSitio((long)sitioRutaPK.hashCode());
			sitioRuta.setTmio1Ruta1(rutaService.findById(sitioRutaPK.getIdRuta()));
			sitioRuta.setTmio1Sitio1(sitioService.findById(sitioRutaPK.getIdSitio()));
			sitioRuta.setId(sitioRutaPK);
			sitioRutaService.save(sitioRuta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/app/sitios-ruta";
	}
	
	@GetMapping("admin/del/sitio-ruta/{id}")
	public String delete(@PathVariable("id") int id) {
		
		try {
			sitioRutaService.delete(sitioRutaService.findByHashCode(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/app/sitios-ruta";
	}
	
}
