package co.edu.icesi.ci.talleres.delegate;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

public interface SitioDelegate {

	public Iterable<Tmio1Sitio> getSitios();
	
	public Tmio1Sitio getSitio(Long id);
	
	public Tmio1Sitio addSitio(Tmio1Sitio sitio);
	
	public void delSitio(Tmio1Sitio sitio);
}
