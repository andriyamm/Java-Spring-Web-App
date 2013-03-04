package org.amm.ams.service.interfaces;

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

	/**
	 * TODO
	 * @param languageId
	 */
	void findCategories(Long languageId);

}