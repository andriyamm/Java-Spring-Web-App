package org.amm.ams.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@NamedNativeQueries({ 
	@NamedNativeQuery(
			name = "findById", 
			query = "select * from categories c where c.categories_id = :categories_id", 
			resultClass = Categories.class) 
	})
@Entity
public class Categories implements Serializable, Identifiable {

	private static final long serialVersionUID = -3582413995673329122L;

	@Id
	@GeneratedValue
	@Column(name = "categories_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "parent")
	public Categories parentCategory;

	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	public List<Categories> subCategories;

	@OneToMany(mappedBy = "categories")
	private Set<CategoriesDef> categoriesDef = new HashSet<CategoriesDef>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Articles> articles = new HashSet<Articles>();

	public Categories() {
		super();
	}

	public Categories(Long id, Categories parentCategory,
			List<Categories> subCategories, Set<CategoriesDef> categoriesDef,
			Set<Articles> articles) {
		super();
		this.id = id;
		this.parentCategory = parentCategory;
		this.subCategories = subCategories;
		this.categoriesDef = categoriesDef;
		this.articles = articles;
	}

	public Categories getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Categories parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Categories> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Categories> subCategories) {
		this.subCategories = subCategories;
	}

	public void addSubCategory(Categories subCategories) {
		if (subCategories == null) {
			this.subCategories = new ArrayList<Categories>();
		}
		this.subCategories.add(subCategories);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	public Set<CategoriesDef> getCategoriesDef() {
		return categoriesDef;
	}

	public void setCategoriesDef(Set<CategoriesDef> categoriesDef) {
		this.categoriesDef = categoriesDef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(articles)
				.append(categoriesDef)
				// .append(parent)
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

		Categories rhs = (Categories) obj;
		return new EqualsBuilder().append(id, rhs.id)
				.append(articles, rhs.articles)
				// .append(parent, rhs.parent)
				.append(categoriesDef, rhs.categoriesDef).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("articles", articles)
				// .append("parent", parent)
				.append("categoriesDef", categoriesDef).toString();
	}

}
