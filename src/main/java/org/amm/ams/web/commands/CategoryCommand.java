package org.amm.ams.web.commands;

public class CategoryCommand {

	private Long categoryId;
	private String categoryName;
	private Long parentCategory;
	private Long languageId;

	public CategoryCommand() {
		super();
	}

	public CategoryCommand(Long categoryId, String categoryName,
			Long parentCategory, Long languageId) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
		this.languageId = languageId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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