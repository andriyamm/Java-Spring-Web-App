package org.amm.ams.dao.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Basic data access object, for all entites.
 * @param <T>
 *            anything, that has ID field.
 */
public interface Dao<T> {
	
	/**
	 * @return count of all rows of the appropriate table in the DB.
	 */
	Long getRowCount();

	/**
	 * @return list of all rows of the appropriate table in the DB.
	 */
	List<T> findAll();

	/**
	 * Removes entity from db.
	 * 
	 * @param entity
	 *            entity to delete.
	 * @return TODO
	 */
	void delete(final T entity);
	

	/**
	 * Removes entity from db.
	 * 
	 * @param entity
	 *            id of the entity to be deleted.
	 * @return TODO
	 */
	void delete(final Long id);

	/**
	 * TODO
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

	List<T> findByNamedQuery(String name, Object[] params);

	List<T> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params);

	T update(T entity);
	
}
