package org.amm.ams.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ArticleDto implements Serializable {

	private static final long serialVersionUID = -816296721109914777L;

	private Long id;
	private Date creationDate;
	private Date publishDate;
	private Boolean is_tmp;
	
	private String title;
	private String body;
	private Long articledefId;

	private String langPrefix;


	public ArticleDto() {
		super();
	}

	public ArticleDto(Long id, String title, String body, String langPrefix,
			Date creationDate, Date publishDate, Boolean is_tmp,
			Long articledefId) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.langPrefix = langPrefix;
		this.creationDate = creationDate;
		this.publishDate = publishDate;
		this.is_tmp = is_tmp;
		this.articledefId = articledefId;
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

	public String getLangPrefix() {
		return langPrefix;
	}

	public void setLangPrefix(String langPrefix) {
		this.langPrefix = langPrefix;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Boolean getIs_tmp() {
		return is_tmp;
	}

	public void setIs_tmp(Boolean is_tmp) {
		this.is_tmp = is_tmp;
	}

	public Long getArticledefId() {
		return articledefId;
	}

	public void setArticledefId(Long articledefId) {
		this.articledefId = articledefId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(title)
				.append(creationDate).append(body).append(langPrefix)
				.append(publishDate).append(is_tmp).append(articledefId)
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

		ArticleDto rhs = (ArticleDto) obj;
		return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title)
				.append(creationDate, rhs.creationDate).append(body, rhs.body)
				.append(publishDate, rhs.publishDate)
				.append(is_tmp, rhs.is_tmp)
				.append(articledefId, rhs.articledefId)
				.append(langPrefix, rhs.langPrefix).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("title", title).append("creationDate", creationDate)
				.append("body", body).append("langPrefix", langPrefix)
				.append("publishDate", publishDate).append("is_tmp", is_tmp)
				.append("articledefId", articledefId).toString();
	}

}
