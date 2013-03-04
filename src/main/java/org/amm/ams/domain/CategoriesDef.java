package org.amm.ams.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@NamedQueries({
	@NamedQuery(
		name="find",
		query="from CategoriesDef a where a.name like :name "),
	@NamedQuery(
		name="findBy",
		query="from CategoriesDef a where a.name =:name and languages=:languages ")
})
@Entity
public class CategoriesDef implements Serializable {

	private static final long serialVersionUID = -5490004658694655615L;

	@Id
	@GeneratedValue
	@Column(name = "categoriesdef_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "languages_id")
	private Languages languages;

	@ManyToOne
	@JoinColumn(name = "categories_id")
	private Categories categories;

	public CategoriesDef() {
		super();
	}

	public CategoriesDef(Long id, String name, Languages lang,
			Categories categories) {
		super();
		this.id = id;
		this.name = name;
		this.languages = lang;
		this.categories = categories;
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

	public Languages getLang() {
		return languages;
	}

	public void setLang(Languages lang) {
		this.languages = lang;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name).append(languages)
				.append(categories).toHashCode();
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

		CategoriesDef rhs = (CategoriesDef) obj;
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name)
				.append(categories, rhs.categories).append(languages, rhs.languages)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("categories", categories).append("lang", languages)
				.toString();
	}
}
