package org.amm.ams.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CategoriesDef implements Serializable {

	private static final long serialVersionUID = -5490004658694655615L;

	@Id
	@GeneratedValue
	@Column(name = "categoriesdef_id")
	private Long id;

	private String name;

	@ManyToOne
	private Languages lang;

	public CategoriesDef() {
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

}
