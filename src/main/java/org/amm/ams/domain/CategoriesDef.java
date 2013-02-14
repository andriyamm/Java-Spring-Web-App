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

	@ManyToOne
	private Articles article;

	@Column(name = "name")
	private String name;

	@ManyToOne
	private Languages lang;

	protected CategoriesDef() {
	}

	public CategoriesDef(Long id, Articles article, String name, Languages lang) {
		this.id = id;
		this.article = article;
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

	public Articles getArticle() {
		return article;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name)
				.append(article).append(lang).toHashCode();
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
				.append(article, rhs.article).append(lang, rhs.lang).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("article", article).append("lang", lang).toString();
	}
}
