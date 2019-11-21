package co.edu.icesi.ci.talleres.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;

@Repository
@Scope("singleton")
public class DAOConductor implements InterfazDAOConductor {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Conductore entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(Tmio1Conductore entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(Tmio1Conductore entity) {
		entityManager.remove(entity);

	}

	@Override
	public Tmio1Conductore findById(String codigo) {
		return entityManager.find(Tmio1Conductore.class, codigo);
	}

	@Override
	public List<Tmio1Conductore> findAll() {
		String jpql = "Select a from Tmio1Conductore a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Conductore> buscarPorNombre(String nombre) {
		String jpql = "Select a from Tmio1Conductore a where a.nombre='" + nombre + "'";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Conductore> buscarPorApellido(String apellido) {
		String jpql = "Select a from Tmio1Conductore a where a.apellidos='" + apellido + "'";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Object[]> buscarConductoresConServicios(Date fecha) {
		String jpql = "Select a, Count(s) from Tmio1Conductore a JOIN Tmio1Servicio s ON a.cedula=s.id.cedulaConductor WHERE :f BETWEEN s.id.fechaInicio AND s.id.fechaFin GROUP BY a ORDER BY a.fechaNacimiento";
		TypedQuery<Object[]> q = entityManager.createQuery(jpql, Object[].class);
		q.setParameter("f", fecha);
		return q.getResultList();
	}

}
