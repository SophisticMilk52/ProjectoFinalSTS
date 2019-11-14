package co.edu.icesi.ci.talleres.dao;

import java.util.Date;
import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

public interface InterfazDAOServicio {
	public void save(Tmio1Servicio entity);
	public void update(Tmio1Servicio entity);
	public void delete(Tmio1Servicio entity);
	public Tmio1Servicio findById(Tmio1ServicioPK codigo);
	public List<Tmio1Servicio> findAll();

}
