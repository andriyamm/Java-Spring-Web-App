package org.amm.ams.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Users implements Serializable, Identifiable {

	private static final long serialVersionUID = 7047085301400189686L;

	@Id
	@GeneratedValue
	@Column(name = "users_id")
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
	private Roles role;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<UserGroups> userGroups = new HashSet<UserGroups>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Articles> articles = new HashSet<Articles>();

	public Users() {

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

	public Set<Articles> getArticles() {
		return articles;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	public Set<UserGroups> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroups> userGroups) {
		this.userGroups = userGroups;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(firstName)
				.append(lastName).append(email).append(profession)
				.append(password).append(lastLogin).append(registrationDate)
				.append(status).append(role).append(userGroups)
				.append(articles).toHashCode();
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

		Users rhs = (Users) obj;
		return new EqualsBuilder().append(id, rhs.id)
				.append(firstName, rhs.firstName)
				.append(lastName, rhs.lastName).append(email, rhs.email)
				.append(articles, rhs.articles).append(password, rhs.password)
				.append(lastLogin, rhs.lastLogin)
				.append(registrationDate, rhs.registrationDate)
				.append(status, rhs.status).append(role, rhs.role)
				.append(userGroups, rhs.userGroups).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id)
				.append("firstName", firstName).append("lastName", lastName)
				.append("email", email).append("lastLogin", lastLogin)
				.append("registrationDate", registrationDate)
				.append("status", status).append("role", role).toString();
	}
}
