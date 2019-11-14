package co.edu.icesi.ci.talleres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.InterfazDAOBus;
import co.edu.icesi.ci.talleres.model.BusType;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;

@Service
public class BusService implements InterfazBusService {

	@Autowired
	private InterfazDAOBus busRepository;

	public BusService(InterfazDAOBus busRepository) {
		this.busRepository = busRepository;
	}

	@Transactional
	public void save(Tmio1Bus bus) {
		busRepository.save(bus);

	}

	@Transactional
	public Tmio1Bus findById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Error al encontrar el bus");
		}
		return busRepository.findById(id);
	}

	@Transactional
	public Iterable<Tmio1Bus> findAll() {
		return busRepository.findAll();
	}

	@Transactional
	public void delete(Tmio1Bus bus) {
		busRepository.delete(bus);

	}

	@Transactional
	public BusType[] getBusTypes() {
		return BusType.values();
	}
}
