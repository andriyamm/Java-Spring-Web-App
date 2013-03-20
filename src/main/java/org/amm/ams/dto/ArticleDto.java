package org.amm.ams.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ArticleDto implements Serializable{

		private static final long serialVersionUID = -816296721109914777L;

	private Long id;
	private String title;
	private String body;
	private String langPrefix;
	private Date creationDate;
	private Date publishDate;
	private Boolean is_tmp;
	private Long articledefId;

	public ArticleDto() {
		super();
	}

	public ArticleDto(Long id, String title, String body, String langPrefix,
			Date creationDate) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.langPrefix = langPrefix;
		this.creationDate = creationDate;
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

	public Long getLang_id() {
		return lang_id;
	}

	public void setLang_id(Long lang_id) {
		this.lang_id = lang_id;
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
		return new EqualsBuilder().append(id, rhs.id)
				.append(title, rhs.title)
				.append(creationDate, rhs.creationDate)
				.append(body, rhs.body)
				.append(langPrefix, rhs.langPrefix)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("title", title)
				.append("creationDate", creationDate)
				.append("body", body)
				.append("langPrefix", langPrefix)
				.toString();
	}

}
