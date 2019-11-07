package com.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usersRole")
public class UsersRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUseRole")
	private Long idUseRole;
	
	@Column(name= "idUsers")
	private Long idUsers;
	
	@Column(name= "idRole")
	private Long idRole;
	
	@Column(name= "roleActive", columnDefinition = "BIT", length = 1)
	private boolean roleActive;
	
	@JoinColumn(name = "idUsers", referencedColumnName = "idUsers", insertable=false, updatable = false)
    @ManyToOne
    private Users users;
	
	@JoinColumn(name = "idRole", referencedColumnName = "idRole", insertable=false, updatable = false)
    @ManyToOne
    private Role roleobj;

	public UsersRole(Long idUseRole, Long idUsers, Long idRole, boolean roleActive) {
		super();
		this.idUseRole = idUseRole;
		this.idUsers = idUsers;
		this.idRole = idRole;
		this.roleActive = roleActive;
	}

	public UsersRole() {
	}

	public Long getIdUseRole() {
		return idUseRole;
	}

	public void setIdUseRole(Long idUseRole) {
		this.idUseRole = idUseRole;
	}

	public Long getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Long idUsers) {
		this.idUsers = idUsers;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public boolean isRoleActive() {
		return roleActive;
	}

	public void setRoleActive(boolean roleActive) {
		this.roleActive = roleActive;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Role getRoleobj() {
		return roleobj;
	}

	public void setRoleobj(Role roleobj) {
		this.roleobj = roleobj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUseRole == null) ? 0 : idUseRole.hashCode());
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
		UsersRole other = (UsersRole) obj;
		if (idUseRole == null) {
			if (other.idUseRole != null)
				return false;
		} else if (!idUseRole.equals(other.idUseRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsersRole [idUseRole=" + idUseRole + "]";
	}
	
	
}
