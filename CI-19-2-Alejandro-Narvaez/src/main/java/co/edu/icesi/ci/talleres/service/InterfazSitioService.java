package co.edu.icesi.ci.talleres.service;

import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

public interface InterfazSitioService {

	public boolean save(Tmio1Sitio sitio) throws Exception;
	public boolean delete(Tmio1Sitio sitio) throws Exception;
	public Tmio1Sitio update(Tmio1Sitio sitio) throws Exception;
	public Tmio1Sitio findById(Long id);
	public List<Tmio1Sitio> findAll();
	
}
