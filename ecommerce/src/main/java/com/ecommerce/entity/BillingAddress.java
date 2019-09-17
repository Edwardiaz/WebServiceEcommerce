package com.ecommerce.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "billingAddress")
public class BillingAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBillingAddress")
	private Long idBillingAddress;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "postalCode")
	private String postalCode;

	@Column(name = "idTelephone")
	private Long idTelephone;

	@Column(name = "idState")
	private Long idState;

	@JoinColumn(name = "idState", referencedColumnName = "idState", insertable = false, updatable = false)
	@ManyToOne
	private State state;

	@JoinColumn(name = "idTelephone", referencedColumnName = "idTelephone", insertable = false, updatable = false)
	@ManyToOne
	private Telephone telephone;
	
	@OneToMany(mappedBy = "billingAddress", fetch = FetchType.EAGER)
	private Set<Orders> listOrders;

	public BillingAddress() {
	}

	public BillingAddress(Long idBillingAddress, String firstName, String lastName, String email, String address1,
			String address2, String postalCode, Long idTelephone, Long idState) {
		super();
		this.idBillingAddress = idBillingAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.postalCode = postalCode;
		this.idTelephone = idTelephone;
		this.idState = idState;
	}

	public Long getIdBillingAddress() {
		return idBillingAddress;
	}

	public void setIdBillingAddress(Long idBillingAddress) {
		this.idBillingAddress = idBillingAddress;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Long getIdTelephone() {
		return idTelephone;
	}

	public void setIdTelephone(Long idTelephone) {
		this.idTelephone = idTelephone;
	}

	public Long getIdState() {
		return idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}
	
	
}
