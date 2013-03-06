package org.amm.ams.dao.interfaces;

import java.util.List;

import org.amm.ams.domain.Category;

public interface CategoryDao extends Dao<Category>,
		FindableDaoCriteria<Category>, FindableDaoNamedQuery<Category> {

	/**
	 * find only top level categories(categories which parent is null)
	 * 
	 * @param langPrefix
	 * 			language prefix
	 * @return
	 * 			List of Category's entities 
	 */
	List<Category> find(String langPrefix);

}
