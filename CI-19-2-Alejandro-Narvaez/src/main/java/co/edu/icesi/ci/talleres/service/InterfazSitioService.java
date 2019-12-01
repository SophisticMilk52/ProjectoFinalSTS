package co.edu.icesi.ci.talleres.service;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

public interface InterfazSitioService {

	public void save(Tmio1Sitio sitio);

	public Tmio1Sitio findById(Long id);

	public Iterable<Tmio1Sitio> findAll();

	public void delete(Tmio1Sitio sitio);
}
