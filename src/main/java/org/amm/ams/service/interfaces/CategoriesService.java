package org.amm.ams.service.interfaces;

import org.amm.ams.domain.Categories;
import org.amm.ams.web.commands.CategoryCommand;

public interface CategoriesService extends AmsService<Categories> {

	void createCategory(CategoryCommand categoryCommand);

}
