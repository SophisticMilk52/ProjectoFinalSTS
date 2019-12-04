package co.edu.icesi.ci.talleres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.InterfazDAOSitioRuta;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

@Service
public class SitioRutaService implements InterfazSitioRutaService {

	@Autowired
	private InterfazDAOSitioRuta sitioRutaDao;
	
	@Override
	@Transactional(readOnly=false)
	public boolean save(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.save(sitiosRuta);
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.update(sitiosRuta);
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.delete(sitiosRuta);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Tmio1SitiosRuta findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Tmio1SitiosRuta findByHashCode(int hashcode) {
		List<Tmio1SitiosRuta> sitiosruta = sitioRutaDao.findAll();
		Tmio1SitiosRuta salida = null;
		for(Tmio1SitiosRuta evaluado : sitiosruta) {
			if(evaluado.getId().hashCode()==hashcode) {
				return evaluado;
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		return sitioRutaDao.findAll();
	}

}
