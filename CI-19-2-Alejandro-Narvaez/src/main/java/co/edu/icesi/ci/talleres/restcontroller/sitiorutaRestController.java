package co.edu.icesi.ci.talleres.restcontroller;


import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;

public interface sitiorutaRestController {

	public Tmio1SitiosRuta getSitioRuta(Integer id);
	
	public Iterable<Tmio1SitiosRuta> getSitiosRutas();
	
	public Tmio1SitiosRuta addSitioRuta(Tmio1SitiosRuta sitioruta);
	
	public Tmio1SitiosRuta delSitioRuta(Integer id);
	
}
