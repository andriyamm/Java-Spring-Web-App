package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.service.interfaces.AmsService;
import org.springframework.transaction.annotation.Transactional;


//public abstract class ServiceImpl<T extends Identifiable> implements Service<T> {
public abstract class AmsServiceImpl<T> implements AmsService<T> {

	/**
	 * the getDao() of descendants
	 * @return 
	 */
	public abstract Dao<T> getDao();
	
	@Override
	@Transactional
	public Long getRowCount() {
		return getDao().getRowCount();
	}

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
