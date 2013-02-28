package org.amm.ams.web.commands;


public class CategoryCommand {

	private String categoryName;
	private Long parentCategory;
	private Long languageId;

	public CategoryCommand() {
		super();
	}

	public CategoryCommand(String categoryName, Long parentCategory,
			Long languageId) {
		super();
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
		this.languageId = languageId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
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
