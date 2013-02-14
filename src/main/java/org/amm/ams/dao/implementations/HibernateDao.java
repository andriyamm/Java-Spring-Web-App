package org.amm.ams.dao.implementations;

import java.util.List;

import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.domain.Identifiable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class HibernateDao<T extends Identifiable> implements Dao<T> {

	protected final Class<T> persistentClass;
	
	@Autowired
	protected SessionFactory sessionFactory;

	public HibernateDao(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public HibernateDao(final Class<T> persistentClass,
			final SessionFactory sessionFactory) {
		this.persistentClass = persistentClass;
		this.sessionFactory = sessionFactory;
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Long getRowCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T insertOrUpdate(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long delete(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
