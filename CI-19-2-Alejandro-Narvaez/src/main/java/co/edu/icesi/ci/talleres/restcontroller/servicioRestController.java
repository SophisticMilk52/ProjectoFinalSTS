package co.edu.icesi.ci.talleres.restcontroller;

import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

public interface servicioRestController {

	public Iterable<Tmio1Servicio> getServicios();
	
	public Tmio1Servicio addServicio(Tmio1Servicio servicio);
	//No estoy seguro si el ID va a ser de ese tipo
	public Tmio1Servicio delServicio(Integer id);
	
}
