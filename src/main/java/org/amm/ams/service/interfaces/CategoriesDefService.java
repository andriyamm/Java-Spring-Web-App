package org.amm.ams.service.interfaces;

import org.amm.ams.domain.CategoriesDef;
import org.amm.ams.web.commands.CategoryCommand;

public interface CategoriesDefService extends AmsService<CategoriesDef> {

	void createCategory(CategoryCommand categoryCommand);

	void editCategory(CategoryCommand categoryCommand);

	void findCategories(Long languageId);

}
