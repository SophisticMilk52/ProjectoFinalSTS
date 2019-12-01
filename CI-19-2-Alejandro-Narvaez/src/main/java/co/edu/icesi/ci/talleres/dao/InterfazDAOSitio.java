package co.edu.icesi.ci.talleres.dao;

import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

public interface InterfazDAOSitio {

	public void save(Tmio1Sitio entity);
	public void update(Tmio1Sitio entity);
	public void delete(Tmio1Sitio entity);
	public Tmio1Sitio findById(Long id);
	public List<Tmio1Sitio> findAll();
	
}
