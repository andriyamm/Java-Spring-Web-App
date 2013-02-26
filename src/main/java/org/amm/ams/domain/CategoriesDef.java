package org.amm.ams.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
	private Languages lang;

	protected CategoriesDef() {
	}

	public CategoriesDef(Long id, String name, Languages lang) {
		this.id = id;
		this.name = name;
		this.lang = lang;
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
		return lang;
	}

	public void setLang(Languages lang) {
		this.lang = lang;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name)
				.append(lang).toHashCode();
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
				.append(lang, rhs.lang).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("lang", lang).toString();
	}
}
