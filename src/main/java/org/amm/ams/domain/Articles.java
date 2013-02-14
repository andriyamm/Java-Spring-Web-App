package org.amm.ams.domain;

import java.io.Serializable;
import java.util.Date;
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
public class Articles implements Serializable, Identifiable {

	private static final long serialVersionUID = -816296721109914665L;

	@Id
	@GeneratedValue
	@Column(name = "articles_id")
	private Long id;

	private String title;
	private String text;
	private Boolean is_tmp;
	private Date creationDate;
	private Date publishDate;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Articles_Users", joinColumns = { @JoinColumn(name = "articles_id") }, inverseJoinColumns = { @JoinColumn(name = "users_id") })
	private Set<Users> users = new HashSet<Users>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Articles_Tags", joinColumns = { @JoinColumn(name = "articles_id") }, inverseJoinColumns = { @JoinColumn(name = "tags_id") })
	private Set<Tags> tags = new HashSet<Tags>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Articles_Categories", joinColumns = { @JoinColumn(name = "articles_id") }, inverseJoinColumns = { @JoinColumn(name = "categories_id") })
	private Set<Categories> categories = new HashSet<Categories>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bookmarks")
	private Set<Bookmarks> bookmarks = new HashSet<Bookmarks>();

	public Articles() {

	}

	public Articles(Long id, String title, String text, Boolean is_tmp,
			Date creationDate, Date publishDate, Set<Users> users,
			Set<Tags> tags, Set<Categories> categories, Set<Bookmarks> bookmarks) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.is_tmp = is_tmp;
		this.creationDate = creationDate;
		this.publishDate = publishDate;
		this.users = users;
		this.tags = tags;
		this.categories = categories;
		this.bookmarks = bookmarks;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIs_tmp() {
		return is_tmp;
	}

	public void setIs_tmp(Boolean is_tmp) {
		this.is_tmp = is_tmp;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Set<Bookmarks> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set<Bookmarks> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(title)
				.append(text).append(is_tmp).append(users).append(tags)
				.append(categories).append(creationDate).append(publishDate)
				.append(bookmarks).toHashCode();
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

		Articles rhs = (Articles) obj;
		return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title)
				.append(text, rhs.text).append(is_tmp, rhs.is_tmp)
				.append(users, rhs.users).append(tags, rhs.tags)
				.append(categories, rhs.categories)
				.append(creationDate, rhs.creationDate)
				.append(publishDate, rhs.publishDate).append(bookmarks, rhs.bookmarks).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("title", title).append("text", text)
				.append("is_tmp", is_tmp).append("users", users)
				.append("tags", tags).append("categories", categories)
				.append("creationDate", creationDate)
				.append("publishDate", publishDate).append("bookmarks", bookmarks).toString();
	}
}
