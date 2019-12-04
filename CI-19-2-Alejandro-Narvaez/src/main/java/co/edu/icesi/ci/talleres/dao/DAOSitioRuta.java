package co.edu.icesi.ci.talleres.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.ci.talleres.model.Tmio1SitiosRuta;
import co.edu.icesi.ci.talleres.model.Tmio1SitiosRutaPK;

@Repository
@Scope("singleton")
public class DAOSitioRuta implements InterfazDAOSitioRuta {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Tmio1SitiosRuta entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1SitiosRuta entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1SitiosRuta entity) {
		entityManager.remove(entity);
	}
/*
	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		return entityManager.find(Tmio1SitiosRuta.class, id);
	}
*/
	@Override
	public List<Tmio1SitiosRuta> findAll() {
		String jpql = "Select a from Tmio1SitiosRuta a";
		return entityManager.createQuery(jpql).getResultList();
	}

}
