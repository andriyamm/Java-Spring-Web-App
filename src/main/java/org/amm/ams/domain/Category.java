package org.amm.ams.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedNativeQueries({ 
	@NamedNativeQuery(
			name = "findAllByLang", 
			query = "SELECT c.category_id, c.parent FROM category AS c LEFT JOIN categorydef AS cd ON c.category_id = cd.category_id WHERE cd.language_id = :lang", 
			resultClass = Category.class) 
	})
@NamedQueries({
	@NamedQuery(
		name="findAll",
		query="from Category "),
})
@Entity
public class Category implements Serializable, Identifiable {

	private static final long serialVersionUID = -3582413995673329122L;

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "parent")
	public Category parentCategory;

	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Category> subCategories;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	//private Set<CategoryDef> categoryDef = new HashSet<CategoryDef>();
	@MapKey(name = "language")
	private Map<Language, CategoryDef> categoryDef;
	//private List<CategoryDef> categoryDef;
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Article> articles = new HashSet<Article>();

	public Category() {
		super();
	}

	public Category(Long id, Category parentCategory) {
		super();
		this.id = id;
		this.parentCategory = parentCategory;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public void addSubCategory(Category subCategories) {
		if (subCategories == null) {
			this.subCategories = new ArrayList<Category>();
		}
		this.subCategories.add(subCategories);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

//	public Set<CategoryDef> getCategoryDef() {
//		return categoryDef;
//	}
//
//	public void setCategoriesDef(Set<CategoryDef> categoryDef) {
//		this.categoryDef = categoryDef;
//	}

	
//	public List<CategoryDef> getCategoryDef() {
//		return categoryDef;
//	}
//
//	public void setCategoryDef(List<CategoryDef> categoryDef) {
//		this.categoryDef = categoryDef;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<Language, CategoryDef> getCategoryDef() {
		return categoryDef;
	}

	public void setCategoryDef(Map<Language, CategoryDef> categoryDef) {
		this.categoryDef = categoryDef;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id)
				//.append(articles)
				//.append(categoryDef)
				.append(parentCategory)
				//.append(subCategories)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		Category rhs = (Category) obj;
		return new EqualsBuilder().append(id, rhs.id)
				//.append(articles, rhs.articles)
				.append(parentCategory, rhs.parentCategory)
				//.append(subCategories, rhs.subCategories)
				//.append(categoryDef, rhs.categoryDef)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				//.append("articles", articles)
				.append("parentCategory", parentCategory)
				//.append("categoryDef", categoryDef)
				//.append("subCategories", subCategories)
				.toString();
	}

}
