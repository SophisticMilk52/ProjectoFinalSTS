package co.edu.icesi.ci.talleres.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.ci.talleres.model.Tmio1Sitio;

@Repository
@Scope("singleton")
public class DAOSitio implements InterfazDAOSitio {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Tmio1Sitio entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(Tmio1Sitio entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(Tmio1Sitio entity) {
		entityManager.remove(entity);

	}

	@Override
	public Tmio1Sitio findById(Long id) {
		return entityManager.find(Tmio1Sitio.class, id);
	}

	@Override
	public List<Tmio1Sitio> findAll() {
		String jpql = "Select a from Tmio1Sitio a";
		return entityManager.createQuery(jpql).getResultList();
	}

}
