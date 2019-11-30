package co.edu.icesi.ci.talleres.restcontroller;

import co.edu.icesi.ci.talleres.model.Tmio1Ruta;

public interface rutaRestController {

	public Iterable<Tmio1Ruta> getRutas();
	
	public Tmio1Ruta addRuta(Tmio1Ruta ruta);
	
	public Tmio1Ruta delRuta(Integer id);
}
