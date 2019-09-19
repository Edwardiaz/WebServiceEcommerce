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
@Table(name = "supplier")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSupplier")
	private Long idSupplier;
	
	@Column(name = "nameSupplier")
	private String nameSupplier;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
	private Set<ProductsSupplier> listComboProducts;

	public Supplier() {
	}

	public Supplier(Long idSupplier, String nameSupplier, String address, String mail, String telephone) {
		super();
		this.idSupplier = idSupplier;
		this.nameSupplier = nameSupplier;
		this.address = address;
		this.mail = mail;
		this.telephone = telephone;
	}

	public Long getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(Long idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
