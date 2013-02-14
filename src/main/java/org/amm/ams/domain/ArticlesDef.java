package org.amm.ams.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArticlesDef implements Serializable {

	private static final long serialVersionUID = -1730592741997081673L;

	@Id
	@GeneratedValue
	@Column(name = "articlesdef_id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body")
	private String body;

	@ManyToOne
	@Column(name = "lang_id")
	private Languages lang;

	public ArticlesDef() {
	}

	public ArticlesDef(Long id, String title, String body, Languages lang) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.lang = lang;
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
		return lang;
	}

	public void setLang(Languages lang) {
		this.lang = lang;
	}

}
