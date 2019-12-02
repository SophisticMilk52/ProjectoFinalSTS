package co.edu.icesi.ci.talleres.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ci.talleres.model.BusType;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.service.InterfazBusService;

@RestController
public class busRestControllerImp implements busRestController {

	@Autowired
	private InterfazBusService busService;
	
	//Aqui cambiare el tipo de retorno, ya que cambiar el servicio a optional me implicaria cambiar otras coaas
	@Override
	@GetMapping("/api/buses/{id}")
	public Tmio1Bus getBus(@PathVariable Integer id) {
		Tmio1Bus busEncontrado = null;
		try {
			busEncontrado = busService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return busEncontrado;
	}
	
	@Override
	@GetMapping("/api/buses")
	public Iterable<Tmio1Bus> getBuses() {
		return busService.findAll();
	}

	@Override
	@PostMapping("/api/buses")
	public Tmio1Bus addBus(@RequestBody Tmio1Bus bus) {
		busService.save(bus);
		return bus;
	}

	@DeleteMapping("/api/buses/{id}")
	public Tmio1Bus delBus(@PathVariable Integer id) {
		Tmio1Bus busEncontrado = null;
		try {
			busEncontrado = busService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		busService.delete(busEncontrado);
		return busEncontrado;
	}
	
	public BusType[] getBusTypes() {
		return busService.getBusTypes();
	}

}
