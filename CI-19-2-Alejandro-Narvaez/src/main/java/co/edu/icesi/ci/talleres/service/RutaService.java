package co.edu.icesi.ci.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.InterfazDAORuta;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;

@Service
public class RutaService implements InterfazRutaService {

	@Autowired
	private InterfazDAORuta rutaRepository;

	public RutaService(InterfazDAORuta rutaRepository) {
		this.rutaRepository = rutaRepository;
	}

	@Transactional
	@Override
	public void save(Tmio1Ruta ruta) {
		if (ruta.getDiaInicio().compareTo(ruta.getDiaFin()) == -1
				&& ruta.getHoraInicio().compareTo(ruta.getHoraFin()) == -1) {
			rutaRepository.save(ruta);
		}
	}

	@Transactional
	@Override
	public Tmio1Ruta findById(Integer id) {

		return rutaRepository.findById(id);
	}

	@Transactional
	@Override
	public Iterable<Tmio1Ruta> findAll() {
		return rutaRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Tmio1Ruta ruta) {
		rutaRepository.delete(ruta);

	}

}
