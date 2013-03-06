package org.amm.ams.service.interfaces;

import java.util.List;

import org.amm.ams.domain.Category;
import org.amm.ams.domain.CategoryDef;
import org.amm.ams.web.commands.CategoryCommand;

public interface CategoryDefService extends AmsService<CategoryDef> {

	/**
	 * TODO
	 * @param categoryCommand
	 */
	void createCategory(CategoryCommand categoryCommand);

	/**
	 * TODO
	 * @param categoryCommand
	 */
	void editCategory(CategoryCommand categoryCommand);

	List<Category> findAllCategories();

	List<Category> find(String langPrefix);

	List<CategoryDef> findDef(String langPrefix);

}
