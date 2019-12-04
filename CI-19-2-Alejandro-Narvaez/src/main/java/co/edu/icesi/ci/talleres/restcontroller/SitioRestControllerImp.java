/*
package co.edu.icesi.ci.talleres.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;
import co.edu.icesi.ci.talleres.service.InterfazSitioService;

@RestController
public class SitioRestControllerImp implements sitioRestController {

	@Autowired
	private InterfazSitioService sitioService;
	
	@Override
	@GetMapping("/api/sitios/{id}")
	public Tmio1Sitio getSitio(@PathVariable Long id) {
		Tmio1Sitio sitio = sitioService.findById(id);
		return sitio;
	}
	
	@Override
	@GetMapping("/api/sitios")
	public Iterable<Tmio1Sitio> getSitios() {
		return sitioService.findAll();
	}

	@Override
	@PostMapping("/api/sitios")
	public Tmio1Sitio addSitio(@RequestBody Tmio1Sitio sitio) {
		sitioService.save(sitio);
		return sitio;
	}

	@Override
	@DeleteMapping("/api/sitios/{id}")
	public Tmio1Sitio delSitio(@PathVariable Long id) {
		Tmio1Sitio sitio = sitioService.findById(id);
		sitioService.delete(sitio);
		return sitio;
	}

}
*/