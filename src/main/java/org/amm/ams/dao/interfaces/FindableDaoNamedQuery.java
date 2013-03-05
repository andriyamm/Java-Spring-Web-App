package org.amm.ams.dao.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Basic find operations by NamedQuery
 * 
 * @param <T> the entity type
 */
public interface FindableDaoNamedQuery<T> {
	
	/**
	 * Find using a named query.
	 * 
	 * @param queryName
	 *            the name of the query
	 * @param params
	 *            the query parameters
	 * 
	 * @return the list of entities
	 */
	List<T> findByNamedQuery(String name, Object[] params);

	/**
	 * Find using a named query.
	 * 
	 * @param queryName
	 *            the name of the query
	 * @param params
	 *            the query parameters
	 * 
	 * @return the list of entities
	 */
	List<T> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params);
}
