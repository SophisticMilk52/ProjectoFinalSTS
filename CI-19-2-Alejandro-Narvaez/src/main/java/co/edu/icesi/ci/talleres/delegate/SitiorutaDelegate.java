package co.edu.icesi.ci.talleres.delegate;

import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

public interface SitiorutaDelegate {

	public Iterable<Tmio1SitiosRuta> getSitiosRutas();
	
	public Tmio1SitiosRuta getSitioRuta(Tmio1SitiosRutaPK id);
	
	public Tmio1SitiosRuta addSitioRuta(Tmio1SitiosRuta sitioruta);
	
	public void delSitioRuta(Tmio1SitiosRuta sitioruta);
	
}
