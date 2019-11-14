package co.edu.icesi.ci.talleres.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;

public interface InterfazDAORuta {

	public void save(Tmio1Ruta entity);
	public void update(Tmio1Ruta entity);
	public void delete(Tmio1Ruta entity);
	public Tmio1Ruta findById(Integer codigo);
	public List<Tmio1Ruta> findAll();
	public List<Tmio1Ruta> buscarPorHoras(BigDecimal horainicio, BigDecimal horafinal);
	public List<Tmio1Ruta> buscarPorFechas(BigDecimal diainicio, BigDecimal diafinal);;
	public List<Tmio1Ruta>buscarConMenosDe10Servicios(Date fecha);
}
