package org.amm.ams.dao.interfaces;

import java.util.List;

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
	 * if entity is seen first time it is inserted into the db, updated
	 * otherwise.
	 * 
	 * @param entity
	 *            entity to proceed.
	 * @return the updated value of entity, already with ID.
	 */
	T insertOrUpdate(final T entity);

	/**
	 * Removes entity from db.
	 * 
	 * @param entity
	 *            entity to delete.
	 * @return TODO
	 */
	Long delete(final T entity);
	

	/**
	 * Removes entity from db.
	 * 
	 * @param entity
	 *            id of the entity to be deleted.
	 * @return TODO
	 */
	Long delete(final Long id);
	
}
