package co.edu.icesi.ci.talleres.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;

@Component
public class ConductorDelegateImp implements ConductorDelegate {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/api/";
	
	public ConductorDelegateImp() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Iterable<Tmio1Conductore> getConductores() {
		Tmio1Conductore[] conductores = restTemplate.getForObject(SERVER + "conductores", Tmio1Conductore[].class);
		List<Tmio1Conductore> at;
		try {
			at = Arrays.asList(conductores);
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public Tmio1Conductore getConductor(String cedula) {
		Tmio1Conductore conductor = restTemplate.getForObject(SERVER + "conductores/" + Integer.parseInt(cedula), Tmio1Conductore.class);
		return conductor;
	}

	@Override
	public Tmio1Conductore addConductor(Tmio1Conductore conductor) {
		Tmio1Conductore conductornuevo = restTemplate.postForEntity(SERVER + "conductores", conductor, Tmio1Conductore.class).getBody();
		return conductornuevo;
	}

	@Override
	public void delConductor(Tmio1Conductore conductor) {
		restTemplate.delete(SERVER + "conductores/" + conductor.getCedula());

	}

}
