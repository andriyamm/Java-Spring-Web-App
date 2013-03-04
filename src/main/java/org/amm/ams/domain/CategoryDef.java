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
		query="from CategoryDef a where a.name like :name "),
	@NamedQuery(
		name="findBy",
		query="from CategoryDef a where a.name =:name and language=:language ")
})
@Entity
public class CategoryDef implements Serializable {

	private static final long serialVersionUID = -5490004658694655615L;

	@Id
	@GeneratedValue
	@Column(name = "categorydef_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public CategoryDef() {
		super();
	}

	public CategoryDef(Long id, String name, Language lang,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.language = lang;
		this.category = category;
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

	public Language getLang() {
		return language;
	}

	public void setLang(Language lang) {
		this.language = lang;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name).append(language)
				.append(category).toHashCode();
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

		CategoryDef rhs = (CategoryDef) obj;
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name)
				.append(category, rhs.category).append(language, rhs.language)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("category", category).append("lang", language)
				.toString();
	}
}
