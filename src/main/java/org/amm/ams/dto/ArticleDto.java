package org.amm.ams.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ArticleDto {

	private Long id;
	private String title;
	private String body;
	private Long lang_id;
	private Date creationDate;

	public ArticleDto() {
		super();
	}

	public ArticleDto(Long id, String title, String body, Long lang_id,
			Date creationDate) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.lang_id = lang_id;
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
				.append(creationDate).append(body).append(lang_id)
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
				.append(lang_id, rhs.lang_id)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("title", title)
				.append("creationDate", creationDate)
				.append("body", body)
				.append("lang_id", lang_id)
				.toString();
	}

}
