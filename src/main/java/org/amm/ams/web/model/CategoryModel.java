package org.amm.ams.web.model;

import java.util.List;

public class CategoryModel {

	private Long id;
	private String name;
	private List<CategoryModel> categoryModels;

	public CategoryModel() {
		super();
	}

	public CategoryModel(Long id, String name,
			List<CategoryModel> categoryModels) {
		super();
		this.id = id;
		this.name = name;
		this.categoryModels = categoryModels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryModel> getCategoryModels() {
		return categoryModels;
	}

	public void setCategoryModels(List<CategoryModel> categoryModels) {
		this.categoryModels = categoryModels;
	}

}
