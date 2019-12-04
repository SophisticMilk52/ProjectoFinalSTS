/*
package co.edu.icesi.ci.talleres.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.service.InterfazSitioRutaService;

@RestController
public class sitiorutaRestControllerImp implements sitiorutaRestController {

	@Autowired
	private InterfazSitioRutaService sitiorutaService;
	
	@Override
	@GetMapping("/api/sitiosrutas/{id}")
	public Tmio1SitiosRuta getSitioRuta(@PathVariable Integer id) {
		Tmio1SitiosRuta sitioruta = sitiorutaService.buscarPorId(id);
		return sitioruta;
	}
	
	@Override
	@GetMapping("/api/sitiosrutas")
	public Iterable<Tmio1SitiosRuta> getSitiosRutas() {
		return sitiorutaService.findAll();
	}

	@Override
	@PostMapping("/api/sitiosrutas")
	public Tmio1SitiosRuta addSitioRuta(@RequestBody Tmio1SitiosRuta sitioruta) {
		sitiorutaService.save(sitioruta);
		return sitioruta;
	}

	@Override
	@DeleteMapping("/api/sitiosrutas/{id}")
	public Tmio1SitiosRuta delSitioRuta(@PathVariable Integer id) {
		Tmio1SitiosRuta sitioruta = sitiorutaService.buscarPorId(id);
		sitiorutaService.delete(sitioruta);
		return sitioruta;
	}

}
*/