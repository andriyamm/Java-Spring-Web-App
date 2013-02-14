package org.amm.ams.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Languages {
	
	@Id
	@GeneratedValue
	@Column(name = "languages_id")
	private Long id;
	
	private String name;
	private String prefix;
	
	protected Languages() {
	}

	public Languages(Long id, String name, String prefix) {
		this.id = id;
		this.name = name;
		this.prefix = prefix;
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

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
}
