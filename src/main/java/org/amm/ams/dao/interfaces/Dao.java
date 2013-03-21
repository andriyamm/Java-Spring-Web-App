package org.amm.ams.dao.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.amm.ams.dto.ArticleDto;

/**
 * Basic data access object, for all entites.
 * 
 * @param <T>
 *            anything, that has ID field.
 */
public interface Dao<T> {

	/**
	 * @return list of all rows of the appropriate table in the DB.
	 */
	List<T> findAll();

	/**
	 * Find an entity by its primary key
	 * 
	 * @param id
	 *            the primary key
	 * @return the entity
	 */
	T findById(Serializable id);

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
	 * save an entity. This can be either a INSERT or UPDATE in the database.
	 * 
	 * @param entity
	 *            the entity to save
	 * 
	 * @return the saved entity
	 */
	T save(T entity);

	/**
	 * INSERT entity in the database.
	 * 
	 * 
	 * @param entity
	 *            the entity to save
	 * 
	 * @return the INSERTed entity
	 */
	T insert(T entity);

	/**
	 * UPDATE entity in the database.
	 * 
	 * @param entity
	 *            the entity to save
	 * 
	 * @return the UPDATEd entity
	 */
	T update(T entity);

}
