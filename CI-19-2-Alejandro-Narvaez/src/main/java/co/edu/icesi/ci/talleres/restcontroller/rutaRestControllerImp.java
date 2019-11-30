package co.edu.icesi.ci.talleres.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ci.talleres.model.Tmio1Ruta;
import co.edu.icesi.ci.talleres.service.InterfazRutaService;

@RestController
public class rutaRestControllerImp implements rutaRestController {

	@Autowired
	private InterfazRutaService rutaService;
	
	@GetMapping("/api/rutas/{id}")
	public Tmio1Ruta getRuta(@PathVariable Integer id) {
		Tmio1Ruta ruta = rutaService.findById(id);
		return ruta;
	}
	
	@Override
	@GetMapping("/api/rutas")
	public Iterable<Tmio1Ruta> getRutas() {
		return rutaService.findAll();
	}

	@Override
	@PostMapping("/api/rutas")
	public Tmio1Ruta addRuta(@RequestBody Tmio1Ruta ruta) {
		rutaService.save(ruta);
		return ruta;
	}

	@Override
	@DeleteMapping("/api/rutas/{id}")
	public Tmio1Ruta delRuta(@PathVariable Integer id) {
		Tmio1Ruta ruta = rutaService.findById(id);
		rutaService.delete(ruta);
		return ruta;
	}

}
