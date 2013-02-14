package org.amm.ams.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tags implements Serializable, Identifiable {

	private static final long serialVersionUID = 3110082861251118641L;

	@Id
	@GeneratedValue
	@Column(name="tags_id")
	private Long id;
	
	private String tags;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="tags")
	private Set<Articles> articles = new HashSet<Articles>();

	public Tags() {
	
	}

	public Tags(Long tags_id, String tags, Set<Articles> articles) {
		super();
		this.id = tags_id;
		this.tags = tags;
		this.articles = articles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long tags_id) {
		this.id = tags_id;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((articles == null) ? 0 : articles.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tags other = (Tags) obj;
		if (articles == null) {
			if (other.articles != null)
				return false;
		} else if (!articles.equals(other.articles))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
