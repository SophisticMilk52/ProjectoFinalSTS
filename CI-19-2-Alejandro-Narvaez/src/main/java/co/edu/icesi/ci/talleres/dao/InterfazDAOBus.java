package co.edu.icesi.ci.talleres.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;

public interface InterfazDAOBus {

		public void save(Tmio1Bus entity);
		public void update(Tmio1Bus entity);
		public void delete(Tmio1Bus entity);
		public Tmio1Bus findById(Integer codigo);
		public List<Tmio1Bus> findAll();
		public List<Tmio1Bus> buscarPorPlaca(String placa);
		public List<Tmio1Bus> buscarPorModelo(Integer modelo);
		public List<Tmio1Bus> buscarPorMarca(String marca);
		public List<Tmio1Bus> buscarDatosServicioVigencia(Date conductor);
	}

