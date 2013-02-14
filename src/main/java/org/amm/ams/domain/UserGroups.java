package org.amm.ams.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class UserGroups {

	@Id
	@GeneratedValue
	@Column(name = "userGroups_id")
	private Long id;

	private String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "UserGroups_Users", joinColumns = { @JoinColumn(name = "userGroups_id") }, inverseJoinColumns = { @JoinColumn(name = "users_id") })
	private Set<Users> users = new HashSet<Users>();

	public UserGroups() {
	}

	public UserGroups(Long id, String name, Set<Users> users) {
		this.id = id;
		this.name = name;
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

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
}
