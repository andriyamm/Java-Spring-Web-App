package org.amm.ams.dao.interfaces;

import java.util.List;

import org.amm.ams.domain.CategoryDef;
import org.amm.ams.domain.Language;

public interface CategoryDefDao extends Dao<CategoryDef>,
		FindableDaoCriteria<CategoryDef>, FindableDaoNamedQuery<CategoryDef> {

	List<CategoryDef> findAllByLang(Language lang);

}
