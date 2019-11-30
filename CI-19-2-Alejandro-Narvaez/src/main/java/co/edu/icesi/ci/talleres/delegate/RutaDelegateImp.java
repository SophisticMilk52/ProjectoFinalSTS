package co.edu.icesi.ci.talleres.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;

@Component
public class RutaDelegateImp implements RutaDelegate {
	
	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/api/";
	
	public RutaDelegateImp() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Iterable<Tmio1Ruta> getRutas() {
		Tmio1Ruta[] rutas = restTemplate.getForObject(SERVER + "rutas", Tmio1Ruta[].class);
		List<Tmio1Ruta> at;
		try {
			at = Arrays.asList(rutas);
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public Tmio1Ruta getRuta(Integer id) {
		Tmio1Ruta ruta = restTemplate.getForObject(SERVER + "rutas/" + id, Tmio1Ruta.class);
		return ruta;
	}

	@Override
	public Tmio1Ruta addRuta(Tmio1Ruta ruta) {
		Tmio1Ruta rutanueva = restTemplate.postForEntity(SERVER + "rutas", ruta, Tmio1Ruta.class).getBody();
		return rutanueva;
	}

	@Override
	public void delRuta(Tmio1Ruta ruta) {
		restTemplate.delete(SERVER + "rutas/" + ruta.getId());

	}

}
