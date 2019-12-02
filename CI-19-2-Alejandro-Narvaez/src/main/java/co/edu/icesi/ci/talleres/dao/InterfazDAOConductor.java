package co.edu.icesi.ci.talleres.dao;

import java.util.Date;
import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;

public interface InterfazDAOConductor {
	public void save(Tmio1Conductore entity);
	public void update(Tmio1Conductore entity);
	public void delete(Tmio1Conductore entity);
	public Tmio1Conductore findById(String codigo);
	public Tmio1Conductore findByCedula(String cedula);
	public List<Tmio1Conductore> findAll();
	public List<Tmio1Conductore> buscarPorNombre(String nombre);
	public List<Tmio1Conductore> buscarPorApellido(String apellido);
	public List<Object[]> buscarConductoresConServicios(Date fecha);
}
