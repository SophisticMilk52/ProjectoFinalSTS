package co.edu.icesi.ci.talleres.restcontroller;


import co.edu.icesi.ci.talleres.model.Tmio1Bus;

public interface busRestController {

	public Tmio1Bus getBus(Integer id);
	
	public Iterable<Tmio1Bus> getBuses();
	
	public Tmio1Bus addBus(Tmio1Bus bus);
	
	public Tmio1Bus delBus(Integer id);
}
