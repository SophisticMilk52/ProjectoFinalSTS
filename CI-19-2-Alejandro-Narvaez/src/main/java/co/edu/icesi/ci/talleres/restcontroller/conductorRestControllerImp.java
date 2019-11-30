package co.edu.icesi.ci.talleres.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;
import co.edu.icesi.ci.talleres.service.InterfazConductorService;

@RestController
public class conductorRestControllerImp implements conductorRestController {

	@Autowired
	private InterfazConductorService conductorService;
	
	@GetMapping("/api/conductores/{id}")
	public Tmio1Conductore getConductor(@PathVariable String cedula) {
		Tmio1Conductore conductor = conductorService.findById(cedula);
		return conductor;
	}
	
	@Override
	@GetMapping("/api/conductores")
	public Iterable<Tmio1Conductore> getConductores() {
		return conductorService.findAll();
	}

	@Override
	@PostMapping("/api/conductores")
	public Tmio1Conductore addConductor(@RequestBody Tmio1Conductore conductor) {
		conductorService.save(conductor);
		return conductor;
	}

	//Aqui tal vez el nombre correcto del parametro sea ID, probar en caso de no funcionar
	@Override
	@DeleteMapping("/api/conductores/{cedula}")
	public Tmio1Conductore delConductor(@PathVariable String cedula) {
		Tmio1Conductore conductor = conductorService.findById(cedula);
		conductorService.delete(conductor);
		return conductor;
	}

}
