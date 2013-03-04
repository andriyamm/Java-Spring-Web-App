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
public class Bookmark {

	@Id
	@GeneratedValue
	@Column(name = "bookmark_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Bookmarks_Articles", joinColumns = { @JoinColumn(name = "bookmark_id") }, inverseJoinColumns = { @JoinColumn(name = "article_id") })
	private Set<Article> articles = new HashSet<Article>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bookmarks")
	private Set<User> users = new HashSet<User>();

	protected Bookmark() {
	}

	public Bookmark(Long id, String name, Set<Article> articles,
			Set<User> users) {
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

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
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

		Bookmark rhs = (Bookmark) obj;
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
