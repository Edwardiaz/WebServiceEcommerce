package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsers")
	private Long idUsers;
	
	@Column(name= "firstName")
	private String firstName;
	
	@Column(name= "secondName")
	private String secondName;
	
	@Column(name= "firstLastName")
	private String firstLastName;
	
	@Column(name= "secondLastName")
	private String secondLastName;
	
	@Column(name= "address")
	private String address;
	
	@Column(name = "creationDate")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(name = "updateDate")
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name= "users")
	private String users;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "password")
	@Type(type="text")
	private String password;
	
	@Column(name= "passwordTemporal")
	@Type(type="text")
	private String passwordTemporal;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private Set<Page> listPage;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private Set<UsersRole> listUsersRole;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private Set<Client> listClient;

	public Users(Long idUsers, String firstName, String secondName, String firstLastName, String secondLastName,
			String address, Date creationDate, Date updateDate, String users, String email, String password,
			String passwordTemporal) {
		super();
		this.idUsers = idUsers;
		this.firstName = firstName;
		this.secondName = secondName;
		this.firstLastName = firstLastName;
		this.secondLastName = secondLastName;
		this.address = address;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.users = users;
		this.email = email;
		this.password = password;
		this.passwordTemporal = passwordTemporal;
	}

	public Users() {
	
	}

	

	public Long getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Long idUsers) {
		this.idUsers = idUsers;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordTemporal() {
		return passwordTemporal;
	}

	public void setPasswordTemporal(String passwordTemporal) {
		this.passwordTemporal = passwordTemporal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsers == null) ? 0 : idUsers.hashCode());
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
		Users other = (Users) obj;
		if (idUsers == null) {
			if (other.idUsers != null)
				return false;
		} else if (!idUsers.equals(other.idUsers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [idUsers=" + idUsers + "]";
	}
	
	
}
