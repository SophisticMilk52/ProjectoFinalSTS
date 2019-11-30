package co.edu.icesi.ci.talleres.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

@Component
public class ServicioDelegateImp implements ServicioDelegate {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";
	
	public ServicioDelegateImp() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Iterable<Tmio1Servicio> getServicios() {
		Tmio1Servicio[] servicios = restTemplate.getForObject(SERVER + "servicios", Tmio1Servicio[].class);
		List<Tmio1Servicio> at;
		try {
			at = Arrays.asList(servicios);
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	//OJO CON ESTO
	@Override
	public Tmio1Servicio getServicio(Tmio1ServicioPK id) {
		Tmio1Servicio servicio = restTemplate.getForObject(SERVER + "servicios/" + id, Tmio1Servicio.class);
		return servicio;
	}

	@Override
	public Tmio1Servicio addServicio(Tmio1Servicio servicio) {
		Tmio1Servicio servicionuevo = restTemplate.postForEntity(SERVER + "servicios", servicio, Tmio1Servicio.class).getBody();
		return servicionuevo;
	}

	@Override
	public void delServicio(Tmio1Servicio servicio) {
		restTemplate.delete(SERVER + "servicios/" + servicio.getId());

	}
	
	//NECESITO IMPLEMENTAR EL METODO PARA OBTENER POR ID
	public Tmio1Servicio getServicioPorId(Integer id) {
		Tmio1Servicio servicio = restTemplate.getForObject(SERVER + "servicios/" + id, Tmio1Servicio.class);
		return servicio;
	}
	
}
