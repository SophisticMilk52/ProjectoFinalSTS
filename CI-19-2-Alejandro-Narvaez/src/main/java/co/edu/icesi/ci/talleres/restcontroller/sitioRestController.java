package co.edu.icesi.ci.talleres.restcontroller;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

public interface sitioRestController {

	public Iterable<Tmio1Sitio> getSitios();
	
	public Tmio1Sitio addSitio(Tmio1Sitio sitio);
	
	public Tmio1Sitio delSitio(Long id);
}
