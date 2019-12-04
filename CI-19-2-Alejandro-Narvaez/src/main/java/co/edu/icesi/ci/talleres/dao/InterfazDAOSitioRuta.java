package co.edu.icesi.ci.talleres.dao;

import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1ServiciosSitioPK;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

public interface InterfazDAOSitioRuta {

	public void save(Tmio1SitiosRuta entity);
	public void update(Tmio1SitiosRuta entity);
	public void delete(Tmio1SitiosRuta entity);
	//public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id);
	public List<Tmio1SitiosRuta> findAll();
	
}
