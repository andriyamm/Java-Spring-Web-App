package org.amm.ams.dao.interfaces;

import java.util.List;

import org.amm.ams.domain.Category;
import org.amm.ams.domain.Language;

public interface CategoryDao extends Dao<Category>,
		FindableDaoCriteria<Category>, FindableDaoNamedQuery<Category> {

	List<Category> find(final Language lang);

}
