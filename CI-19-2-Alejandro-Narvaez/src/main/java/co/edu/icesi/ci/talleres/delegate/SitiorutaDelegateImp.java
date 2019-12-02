package co.edu.icesi.ci.talleres.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

@Component
public class SitiorutaDelegateImp implements SitiorutaDelegate {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/api/";
	
	public SitiorutaDelegateImp() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Iterable<Tmio1SitiosRuta> getSitiosRutas() {
		Tmio1SitiosRuta[] sitiosrutas = restTemplate.getForObject(SERVER + "sitiosrutas", Tmio1SitiosRuta[].class);
		List<Tmio1SitiosRuta> at;
		try {
			at = Arrays.asList(sitiosrutas);
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public Tmio1SitiosRuta getSitioRuta(Tmio1SitiosRutaPK id) {
		Tmio1SitiosRuta sitioruta = restTemplate.getForObject(SERVER + "sitiosrutas/" + id, Tmio1SitiosRuta.class);
		return sitioruta;
	}

	@Override
	public Tmio1SitiosRuta addSitioRuta(Tmio1SitiosRuta sitioruta) {
		Tmio1SitiosRuta sitiorutanuevo = restTemplate.postForEntity(SERVER + "sitiosrutas", sitioruta, Tmio1SitiosRuta.class).getBody();
		return sitiorutanuevo;
	}

	@Override
	public void delSitioRuta(Tmio1SitiosRuta sitioruta) {
		restTemplate.delete(SERVER + "sitiosrutas/" + sitioruta.getIdHash());

	}

}
