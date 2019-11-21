package co.edu.icesi.ci.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.DAOServicio;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

@Service
public class ServicioService implements InterfazServicioService {

	private DAOServicio serviciosRepository;

	@Autowired
	public ServicioService(DAOServicio serviciosRepository) {
		this.serviciosRepository = serviciosRepository;
	}

	@Transactional
	@Override
	public void save(Tmio1Servicio servicio) {
		if (servicio.getId().getFechaInicio().before(servicio.getId().getFechaFin())) {
			serviciosRepository.save(servicio);
		}
	}

	@Transactional
	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		return serviciosRepository.findById(id);
	}

	@Transactional
	public Tmio1Servicio buscarPorId(Integer id) {
		Iterable<Tmio1Servicio> todos = findAll();
		for (Tmio1Servicio servicio : todos) {
			if (servicio.getIdHash().equals(id)) {
				return servicio;
			}
		}
		return null;
	}

	@Transactional
	@Override
	public Iterable<Tmio1Servicio> findAll() {
		return serviciosRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Tmio1Servicio servicio) {
		serviciosRepository.delete(servicio);
	}

}
