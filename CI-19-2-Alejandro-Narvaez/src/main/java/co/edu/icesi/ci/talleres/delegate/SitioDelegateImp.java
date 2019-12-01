package co.edu.icesi.ci.talleres.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

@Component
public class SitioDelegateImp implements SitioDelegate {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/api/";
	
	public SitioDelegateImp() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Iterable<Tmio1Sitio> getSitios() {
		Tmio1Sitio[] sitios = restTemplate.getForObject(SERVER + "sitios", Tmio1Sitio[].class);
		List<Tmio1Sitio> at;
		try {
			at = Arrays.asList(sitios);
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public Tmio1Sitio getSitio(Long id) {
		Tmio1Sitio sitio = restTemplate.getForObject(SERVER + "sitios/" + id, Tmio1Sitio.class);
		return sitio;
	}

	@Override
	public Tmio1Sitio addSitio(Tmio1Sitio sitio) {
		Tmio1Sitio sitionuevo = restTemplate.postForEntity(SERVER + "sitios", sitio, Tmio1Sitio.class).getBody();
		return sitionuevo;
	}

	@Override
	public void delSitio(Tmio1Sitio sitio) {
		restTemplate.delete(SERVER + "sitios/" + sitio.getId());

	}

}
