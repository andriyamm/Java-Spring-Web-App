package org.amm.ams.dao.interfaces;

import java.util.List;

import org.hibernate.criterion.Criterion;


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
	
	/**
	 * @param criterions
	 *            criterions for search.
	 * @return list of rows of the appropriate table in the DB,filtered by all
	 *         criterions.
	 */
	List<T> findByCriterions(final Criterion... criterions);
	
	
	/**
	 * 
	 * @param fieldName
	 * 			name of field for search on equals to value
	 * @param value
	 * 			the value of field
	 * @return all entities having fields with such fieldName equal to value
	 */
	List<T> findByParameter(String fieldName, Object value);
	
	/**
	 * @param criterions
	 *            criterions for search.
	 * @return list of rows of the appropriate table in the DB,filtered by one
	 *         of criterions, inteprating them like one disjunction.
	 */
	List<T> findByOneOfCriterions(final Criterion... criterions);
}
