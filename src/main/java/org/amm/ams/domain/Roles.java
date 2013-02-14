package org.amm.ams.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Roles implements Serializable, Identifiable {

	private static final long serialVersionUID = 7524969555498132484L;

	@Id
	@GeneratedValue
	private Long id;

	private String role;

	public Roles() {

	}

	public Roles(Long id, String role) {
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(role).toHashCode();
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

		Roles rhs = (Roles) obj;
		return new EqualsBuilder().append(id, rhs.id).append(role, rhs.role)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("role", role)
				.toString();
	}

}
