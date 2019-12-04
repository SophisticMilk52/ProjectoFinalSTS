package co.edu.icesi.ci.talleres.service;

import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

public interface InterfazSitioRutaService {
/*
	public void save(Tmio1SitiosRuta sitioruta);

	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id);

	public Iterable<Tmio1SitiosRuta> findAll();

	public void delete(Tmio1SitiosRuta sitioruta);
	
	public Tmio1SitiosRuta buscarPorId(Integer id);
	*/
	
	public boolean save(Tmio1SitiosRuta sitiosRuta) throws Exception;
	public boolean update(Tmio1SitiosRuta sitiosRuta) throws Exception;
	public boolean delete(Tmio1SitiosRuta sitiosRuta) throws Exception;
	public Tmio1SitiosRuta findById();
	public Tmio1SitiosRuta findByHashCode(int hashcode);
	public List<Tmio1SitiosRuta> findAll();
	
}
