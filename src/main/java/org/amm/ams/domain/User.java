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
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class User implements Serializable, Identifiable {

	private static final long serialVersionUID = 7047085301400189686L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String profession;

	private String password;
	private Date lastLogin;
	private Date registrationDate;
	private String status;

	@ManyToOne
	private Role role;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<UserGroup> userGroups = new HashSet<UserGroup>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Article> articles = new HashSet<Article>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Users_Bookmarks", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "bookmark_id") })
	private Set<Bookmark> bookmarks = new HashSet<Bookmark>();

	protected User() {
	}

	public User(Long id, String firstName, String lastName, String email,
			String profession, String password, Date lastLogin,
			Date registrationDate, String status, Role role,
			Set<UserGroup> userGroups, Set<Article> articles,
			Set<Bookmark> bookmarks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.profession = profession;
		this.password = password;
		this.lastLogin = lastLogin;
		this.registrationDate = registrationDate;
		this.status = status;
		this.role = role;
		this.userGroups = userGroups;
		this.articles = articles;
		this.bookmarks = bookmarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(firstName)
				.append(lastName).append(email).append(profession)
				.append(password).append(lastLogin).append(registrationDate)
				.append(status).append(role).append(userGroups)
				.append(articles).append(bookmarks).toHashCode();
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

		User rhs = (User) obj;
		return new EqualsBuilder().append(id, rhs.id)
				.append(firstName, rhs.firstName)
				.append(lastName, rhs.lastName).append(email, rhs.email)
				.append(articles, rhs.articles).append(password, rhs.password)
				.append(lastLogin, rhs.lastLogin)
				.append(registrationDate, rhs.registrationDate)
				.append(status, rhs.status).append(role, rhs.role)
				.append(userGroups, rhs.userGroups)
				.append(bookmarks, rhs.bookmarks).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("firstName", firstName).append("lastName", lastName)
				.append("email", email).append("lastLogin", lastLogin)
				.append("registrationDate", registrationDate)
				.append("status", status).append("role", role)
				.append("bookmarks", bookmarks).toString();
	}
}
