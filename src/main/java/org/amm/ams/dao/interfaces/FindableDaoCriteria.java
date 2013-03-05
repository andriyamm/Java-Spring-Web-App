package org.amm.ams.dao.interfaces;


/**
 * Basic find operations by NamedQuery
 * 
 * @param <T> the entity type
 */
public interface FindableDaoCriteria<T> {
	
	/**
	 * @return count of all rows of the appropriate table in the DB.
	 */
	Long getRowCount();
	
}
