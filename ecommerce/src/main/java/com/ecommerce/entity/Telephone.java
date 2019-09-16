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
@Table(name = "telephone")
public class Telephone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTelephone")
	private Long idTelephone;
	
	@Column(name= "telephone")
	private String telephone;
	
	@OneToMany(mappedBy = "telephone", fetch = FetchType.EAGER)
	private Set<BillingAddress> listBillingAddress;

	public Telephone() {
	}

	public Telephone(Long idTelephone, String telephone) {
		super();
		this.idTelephone = idTelephone;
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTelephone == null) ? 0 : idTelephone.hashCode());
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
		Telephone other = (Telephone) obj;
		if (idTelephone == null) {
			if (other.idTelephone != null)
				return false;
		} else if (!idTelephone.equals(other.idTelephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telephone [idTelephone=" + idTelephone + "]";
	}

	public Long getIdTelephone() {
		return idTelephone;
	}

	public void setIdTelephone(Long idTelephone) {
		this.idTelephone = idTelephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
