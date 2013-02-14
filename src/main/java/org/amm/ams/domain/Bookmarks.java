package org.amm.ams.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Bookmarks {

	@Id
	@GeneratedValue
	@Column(name = "bookmarks_id")
	private Long id;

	private String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Bookmarks_Articles", joinColumns = { @JoinColumn(name = "bookmarks_id") }, inverseJoinColumns = { @JoinColumn(name = "articles_id") })
	private Set<Articles> articles = new HashSet<Articles>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Users> users = new HashSet<Users>();

	protected Bookmarks() {
	}

	public Bookmarks(Long id, String name, Set<Articles> articles,
			Set<Users> users) {
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.users = users;
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

	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name)
				.append(articles).append(users).toHashCode();
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

		Bookmarks rhs = (Bookmarks) obj;
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name)
				.append(articles, rhs.articles).append(users, rhs.users)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("articles", articles).append("users", users).toString();
	}
}
