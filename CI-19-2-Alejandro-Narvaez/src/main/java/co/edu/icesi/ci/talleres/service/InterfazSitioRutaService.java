package co.edu.icesi.ci.talleres.service;

import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

public interface InterfazSitioRutaService {

	public void save(Tmio1SitiosRuta sitioruta);

	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id);

	public Iterable<Tmio1SitiosRuta> findAll();

	public void delete(Tmio1SitiosRuta sitioruta);
	
	public Tmio1SitiosRuta buscarPorId(Integer id);
	
}
