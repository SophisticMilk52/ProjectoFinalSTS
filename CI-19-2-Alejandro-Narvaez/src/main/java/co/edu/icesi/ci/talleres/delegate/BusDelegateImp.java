package co.edu.icesi.ci.talleres.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;

@Component
public class BusDelegateImp implements BusDelegate {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";
	
	public BusDelegateImp() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Iterable<Tmio1Bus> getBuses() {
		Tmio1Bus[] buses = restTemplate.getForObject(SERVER + "buses", Tmio1Bus[].class);
		List<Tmio1Bus> at;
		try {
			at = Arrays.asList(buses);
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public Tmio1Bus getBus(Integer id) {
		Tmio1Bus bus = restTemplate.getForObject(SERVER + "buses/" + id, Tmio1Bus.class);
		return bus;
	}

	@Override
	public Tmio1Bus addBus(Tmio1Bus bus) {
		Tmio1Bus busnuevo = restTemplate.postForEntity(SERVER + "buses", bus, Tmio1Bus.class).getBody();
		return busnuevo;
	}

	@Override
	public void delBus(Tmio1Bus bus) {
		restTemplate.delete(SERVER + "buses/" + bus.getId());

	}
	

}
