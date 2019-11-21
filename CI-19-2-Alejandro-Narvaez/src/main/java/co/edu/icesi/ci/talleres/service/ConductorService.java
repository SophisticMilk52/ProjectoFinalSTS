package co.edu.icesi.ci.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.InterfazDAOConductor;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;

@Service
public class ConductorService implements InterfazConductorService {

	@Autowired
	private InterfazDAOConductor conductorRepository;

	public ConductorService(InterfazDAOConductor conductorRepository) {
		this.conductorRepository = conductorRepository;
	}

	@Transactional
	@Override
	public void save(Tmio1Conductore conductor) {
		if (conductor.getFechaNacimiento().before(conductor.getFechaContratacion())) {
			conductorRepository.save(conductor);
		}
	}

	@Transactional
	@Override
	public Tmio1Conductore findById(String cedula) {

		return conductorRepository.findById(cedula);
	}

	@Override
	@Transactional
	public Iterable<Tmio1Conductore> findAll() {
		return conductorRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Tmio1Conductore conductor) {
		conductorRepository.delete(conductor);

	}

}
