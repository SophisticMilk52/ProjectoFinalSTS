package co.edu.icesi.ci.talleres.service;

import java.util.Optional;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

public interface InterfazServicioService {

	public void save(Tmio1Servicio servicio);

	public Tmio1Servicio findById(Tmio1ServicioPK id);

	public Iterable<Tmio1Servicio> findAll();

	public void delete(Tmio1Servicio servicio);
	
}
