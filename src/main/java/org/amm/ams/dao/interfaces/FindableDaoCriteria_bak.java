package org.amm.ams.dao.interfaces;

import java.util.List;

/**
 * Basic find operations by NamedQuery
 * 
 * @param <T> the entity type
 */
public interface FindableDaoCriteria_bak<T> {
	
	/**
	 * @return count of all rows of the appropriate table in the DB.
	 */
	Long getRowCount();
	
	/**
	 * @return list of all rows of the appropriate table in the DB.
	 */
	List<T> findAll();
}
