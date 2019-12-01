package co.edu.icesi.ci.talleres.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.InterfazDAOSitio;
import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

@Service
public class SitioService implements InterfazSitioService {

	private InterfazDAOSitio sitioRepository;
	
	@Autowired
	public SitioService(InterfazDAOSitio sitioRepository) {
		this.sitioRepository = sitioRepository;
	}
	
	@Transactional
	@Override
	public void save(Tmio1Sitio sitio) {
		sitioRepository.save(sitio);
	}

	@Transactional
	@Override
	public Tmio1Sitio findById(Long id) {
		return sitioRepository.findById(id);
	}
	
	@Override
	@Transactional
	public Iterable<Tmio1Sitio> findAll() {
		return sitioRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Tmio1Sitio sitio) {
		sitioRepository.delete(sitio);

	}

}
