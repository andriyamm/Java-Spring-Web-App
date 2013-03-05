package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.service.interfaces.AmsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public abstract class AmsServiceImpl<T> implements AmsService<T> {

	/**
	 * the getDao() of descendants
	 * @return 
	 */
	public abstract Dao<T> getDao();
	
	@Override
	@Transactional
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	@Transactional
	public T findByID(Long id) {
		return getDao().findById(id);
	}

	@Override
	@Transactional
	public T insert(T entity) {
		return getDao().insert(entity);
	}

	@Override
	@Transactional
	public T update(T entity) {
		return getDao().update(entity);
	}
	
	@Override
	@Transactional
	public void delete(T entity) {
		getDao().delete(entity);
	}

}
