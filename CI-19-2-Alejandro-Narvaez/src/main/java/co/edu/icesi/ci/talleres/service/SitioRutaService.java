package co.edu.icesi.ci.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.InterfazDAOSitioRuta;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

@Service
public class SitioRutaService implements InterfazSitioRutaService {

	private InterfazDAOSitioRuta sitiorutaRepository;
	
	@Autowired
	public SitioRutaService(InterfazDAOSitioRuta sitiorutaRepository) {
		this.sitiorutaRepository = sitiorutaRepository;
	}
	
	@Transactional
	@Override
	public void save(Tmio1SitiosRuta sitioruta) {
		sitiorutaRepository.save(sitioruta);
	}

	@Transactional
	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		return sitiorutaRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Tmio1SitiosRuta buscarPorId(Integer id) {
		Iterable<Tmio1SitiosRuta> todos = findAll();
		for (Tmio1SitiosRuta sitioruta : todos) {
			if (sitioruta.getIdHash().equals(id)) {
				return sitioruta;
			}
		}
		return null;
	}

	@Transactional
	@Override
	public Iterable<Tmio1SitiosRuta> findAll() {
		return sitiorutaRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Tmio1SitiosRuta sitioruta) {
		sitiorutaRepository.delete(sitioruta);

	}


}
