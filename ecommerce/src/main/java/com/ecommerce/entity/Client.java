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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private Long idClient;
	
	@Column(name= "firstName")
	private String firstName;
	
	@Column(name= "secondName")
	private String secondName;
	
	@Column(name= "firstLastName")
	private String firstLastName;
	
	@Column(name= "secondLastName")
	private String secondLastName;
	
	@Column(name= "mail", unique= true)
	private String mail;

	@Column(name= "password")
	private String password;
	
	@Column(name= "userName", unique= true)
	private String userName;
	
	@Column(name= "address")
	private String address;
	
	@Column(name = "registrationDate")
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	@Column(name = "updateDate")
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name= "idUsers")
	private Long idUsers;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<ClientCategoryClient> listClientCategoryClient;
	
	@JoinColumn(name = "idUsers", referencedColumnName = "idUsers", insertable=false, updatable = false)
    @ManyToOne
    private Users users;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<Invoice> listInvoice;
		
	public Client() {

	}

	public Client(Long idClient, String firstName, String secondName, String firstLastName, String secondLastName,
			String mail, String password, String userName, String address, Date registrationDate,
			Date updateDate, Long idUsers) {
		super();
		this.idClient = idClient;
		this.firstName = firstName;
		this.secondName = secondName;
		this.firstLastName = firstLastName;
		this.secondLastName = secondLastName;
		this.mail = mail;
		this.password = password;
		this.userName = userName;
		this.address = address;
		this.registrationDate = registrationDate;
		this.updateDate = updateDate;
		this.idUsers = idUsers;
	}

	public Long getIdClient() {
		return idClient;
	}



	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
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
		Client other = (Client) obj;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + "]";
	}
	
	
}
