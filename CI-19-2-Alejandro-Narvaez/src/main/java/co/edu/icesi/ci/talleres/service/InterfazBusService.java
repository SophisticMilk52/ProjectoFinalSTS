package co.edu.icesi.ci.talleres.service;

import java.util.Optional;

import co.edu.icesi.ci.talleres.model.BusType;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;

public interface InterfazBusService {

	public void save(Tmio1Bus bus);

	public Tmio1Bus findById(Integer id) throws Exception;

	public Iterable<Tmio1Bus> findAll();

	public void delete(Tmio1Bus bus);
	
	public BusType[] getBusTypes();
	
}
