package org.amm.ams.dao.interfaces;

import java.util.List;

import org.amm.ams.domain.CategoryDef;

public interface CategoryDefDao extends Dao<CategoryDef>,
		FindableDaoCriteria<CategoryDef>, FindableDaoNamedQuery<CategoryDef> {

	/**
	 * TODO
	 * 
	 * @param langPrefix
	 * 			language prefix
	 * @return
	 * 			List of CategoryDef's entities 
	 */
	List<CategoryDef> find(String langPrefix);

}
