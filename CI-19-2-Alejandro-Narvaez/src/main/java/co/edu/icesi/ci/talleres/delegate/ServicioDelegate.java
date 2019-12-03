package co.edu.icesi.ci.talleres.delegate;

import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

public interface ServicioDelegate {

	public Iterable<Tmio1Servicio> getServicios();
	
	public Tmio1Servicio getServicio(Integer id);
	
	public Tmio1Servicio addServicio(Tmio1Servicio servicio);
	

	public Tmio1Servicio UpdateServicio(Tmio1Servicio servicio);
	
	public void delServicio(Tmio1Servicio servicio);
	
}
