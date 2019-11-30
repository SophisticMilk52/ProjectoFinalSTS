package co.edu.icesi.ci.talleres.delegate;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;

public interface BusDelegate {

	public Iterable<Tmio1Bus> getBuses();
	
	public Tmio1Bus getBus(Integer id);
	
	public Tmio1Bus addBus(Tmio1Bus bus);
	
	public void delBus(Tmio1Bus bus);
}

