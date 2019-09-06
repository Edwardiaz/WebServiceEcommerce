package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole")
	private Long idRole;
	
	@Column(name= "role")
	private String rolename;
	
	@Column(name= "status", columnDefinition = "BIT", length = 1)
	private boolean status;
	
	@OneToMany(mappedBy = "roleobj", fetch = FetchType.EAGER)
	private Set<UsersRole> listUsersRole;
	
	@OneToMany(mappedBy = "roleobj", fetch = FetchType.EAGER)
	private Set<RoleOptions> listRoleOptions;

	public Role(Long idRole, String role, boolean status) {
		super();
		this.idRole = idRole;
		this.rolename = role;
		this.status = status;
	}

	public Role() {
	
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String role) {
		this.rolename = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
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
		Role other = (Role) obj;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + "]";
	}

	
}
