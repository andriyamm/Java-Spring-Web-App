package org.amm.ams.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class ArticlesDef implements Serializable {

	private static final long serialVersionUID = -1730592741997081673L;

	@Id
	@GeneratedValue
	@Column(name = "articlesdef_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "articles_id")
	private Articles article;

	@Column(name = "title")
	private String title;

	@Column(name = "body")
	private String body;

	@ManyToOne
	@JoinColumn(name = "languages_id")
	private Languages languages;

	public ArticlesDef() {
	}

	public ArticlesDef(Long id, Articles article, String title, String body,
			Languages languages) {
		this.id = id;
		this.article = article;
		this.title = title;
		this.body = body;
		this.languages = languages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Languages getLang() {
		return languages;
	}

	public void setLang(Languages lang) {
		this.languages = lang;
	}

	public Articles getArticle() {
		return article;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(article)
				.append(title).append(body).append(languages).toHashCode();
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

		ArticlesDef rhs = (ArticlesDef) obj;
		return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title)
				.append(article, rhs.article).append(body, rhs.body)
				.append(languages, rhs.languages).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("title", title).append("article", article)
				.append("body", body).append("lang", languages).toString();
	}
}