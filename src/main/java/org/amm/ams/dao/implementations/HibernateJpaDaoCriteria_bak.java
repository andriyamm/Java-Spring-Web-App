package org.amm.ams.dao.implementations;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.amm.ams.dao.interfaces.FindableDaoCriteria_bak;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Required;

public class HibernateJpaDaoCriteria_bak<T> implements FindableDaoCriteria_bak<T> {

	private final Class<T> persistentClass;

	private EntityManager entityManager;

	// constructors

	@SuppressWarnings("unchecked")
	public HibernateJpaDaoCriteria_bak() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public HibernateJpaDaoCriteria_bak(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	// getters and setters

	@Required
	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	//methods
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {

		Session session = (Session) getEntityManager().getDelegate();
		Criteria crit = session.createCriteria(getPersistentClass());

		return crit.list();
	}
	
	@Override
	public Long getRowCount() {

		Session session = (Session) entityManager.getDelegate();

		Criteria criteria = session.createCriteria(persistentClass);
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();

		return count;
	}
}
