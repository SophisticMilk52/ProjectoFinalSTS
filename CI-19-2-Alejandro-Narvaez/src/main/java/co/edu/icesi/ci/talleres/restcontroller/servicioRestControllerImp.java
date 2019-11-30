package co.edu.icesi.ci.talleres.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;
import co.edu.icesi.ci.talleres.service.InterfazServicioService;

@RestController
public class servicioRestControllerImp implements servicioRestController {

	@Autowired
	private InterfazServicioService servicioService;
	
	@GetMapping("/api/servicios/{id}")
	public Tmio1Servicio getServicio(@PathVariable Integer id) {
		Tmio1Servicio servicio = servicioService.buscarPorId(id);
		return servicio;
	}
	
	@Override
	@GetMapping("/api/servicios")
	public Iterable<Tmio1Servicio> getServicios() {
		return servicioService.findAll();
	}

	@Override
	@PostMapping("/api/servicios")
	public Tmio1Servicio addServicio(@RequestBody Tmio1Servicio servicio) {
		servicioService.save(servicio);
		return servicio;
	}

	@Override
	@DeleteMapping("/api/servicios/{id}")
	public Tmio1Servicio delServicio(@PathVariable Integer id) {
		Tmio1Servicio servicio = servicioService.buscarPorId(id);
		servicioService.delete(servicio);
		return servicio;
	}
	
	public Tmio1Servicio buscarPorId(Integer id) {
		return servicioService.buscarPorId(id);
	}

}
