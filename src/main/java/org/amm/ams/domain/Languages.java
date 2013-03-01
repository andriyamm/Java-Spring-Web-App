package org.amm.ams.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Languages implements Serializable {

	private static final long serialVersionUID = -2678498818708026361L;

	@Id
	@GeneratedValue
	@Column(name = "languages_id")
	private Long id;

	private String name;

	@Column(unique = true, nullable = false)
	private String prefix;

	@OneToMany(mappedBy = "languages")
	private Set<CategoriesDef> categoriesDef = new HashSet<CategoriesDef>();

	@OneToMany(mappedBy = "languages")
	private Set<ArticlesDef> articlesDef = new HashSet<ArticlesDef>();

	public Languages() {
	}

	public Languages(Long id, String name, String prefix,
			Set<CategoriesDef> categoriesDef, Set<ArticlesDef> articlesDef) {
		super();
		this.id = id;
		this.name = name;
		this.prefix = prefix;
		this.categoriesDef = categoriesDef;
		this.articlesDef = articlesDef;
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

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Set<CategoriesDef> getCategoriesDef() {
		return categoriesDef;
	}

	public void setCategoriesDef(Set<CategoriesDef> categoriesDef) {
		this.categoriesDef = categoriesDef;
	}

	public Set<ArticlesDef> getArticlesDef() {
		return articlesDef;
	}

	public void setArticlesDef(Set<ArticlesDef> articlesDef) {
		this.articlesDef = articlesDef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name)
				.append(categoriesDef).append(articlesDef).append(prefix)
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

		Languages rhs = (Languages) obj;
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name)
				.append(articlesDef, rhs.articlesDef)
				.append(categoriesDef, rhs.categoriesDef)
				.append(prefix, rhs.prefix).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("articlesDef", articlesDef)
				.append("categoriesDef", categoriesDef)
				.append("prefix", prefix).toString();
	}
}
