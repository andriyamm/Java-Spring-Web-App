package org.amm.ams.service.interfaces;

import java.util.List;

//public interface Service<T extends Identifiable> {
public interface AmsService<T> {

	/**
	 * @return list of all rows of the appropriate table in the DB.
	 */
	List<T> findAll();

	/**
	 * @param id
	 *            - ID to get
	 * @return the entity from db with appropriate ID.
	 */
	T findByID(final Long id);

	/**
	 * Removes entity from db.
	 * 
	 * @param entity
	 *            entity to delete.
	 */
	void delete(final T entity);

	/**
	 * insert entity into the db
	 * 
	 * @param entity
	 *            entity to proceed.
	 * @return
	 */
	T insert(T entity);

	/**
	 * update entity into the db
	 * 
	 * @param entity
	 *            entity to proceed.
	 * @return
	 */
	T update(T entity);
}
