package co.edu.icesi.ci.talleres.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;

@Repository
@Scope("singleton")
public class DAORuta implements InterfazDAORuta {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Ruta entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(Tmio1Ruta entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(Tmio1Ruta entity) {
		entityManager.remove(entity);

	}

	@Override
	public Tmio1Ruta findById(Integer codigo) {
		return entityManager.find(Tmio1Ruta.class, codigo);
	}

	@Override
	public List<Tmio1Ruta> findAll() {
		String jpql = "Select a from Tmio1Ruta a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Ruta> buscarPorHoras(BigDecimal horaInicio, BigDecimal horaFin) {
		String jpql = "Select a from Tmio1Ruta a where a.horaInicio >= '" + horaInicio.intValue()
				+ "' and a.horaFin <= '" + horaFin.intValue() + "'";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Ruta> buscarPorFechas(BigDecimal diaInicio, BigDecimal diaFin) {
		String jpql = "Select a from Tmio1Ruta a where a.diaInicio >= '" + diaInicio.intValue() + "' and a.diaFin <= '"
				+ diaFin.intValue() + "'";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Ruta> buscarConMenosDe10Servicios(Date fecha) {
		String jpql = "Select a from Tmio1Ruta a where " + "( SELECT Count(s) FROM Tmio1Servicio s WHERE s.id.idRuta = a.id AND "
				+ ":f Between s.id.fechaInicio AND s.id.fechaFin)<10";
		TypedQuery<Tmio1Ruta> q = entityManager.createQuery(jpql, Tmio1Ruta.class);
		q.setParameter("f", fecha);
		return q.getResultList();
	}
}
