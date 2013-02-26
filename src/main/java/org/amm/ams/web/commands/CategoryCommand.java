package org.amm.ams.web.commands;


public class CategoryCommand {

	private String categoryName;
	private Long parentCategory;
	private String languagePrefix;

	public CategoryCommand() {
		super();
	}

	public CategoryCommand(String categoryName, Long parentCategory,
			String languagePrefix) {
		super();
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
		this.languagePrefix = languagePrefix;
	}

	public String getLanguagePrefix() {
		return languagePrefix;
	}

	public void setLanguagePrefix(String languagePrefix) {
		this.languagePrefix = languagePrefix;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Long parentCategory) {
		this.parentCategory = parentCategory;
	}

}
