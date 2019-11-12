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
@Table(name = "settings")
public class Settings implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSettings")
	private Long idSettings;
	
	@Column(name= "nameShop")
	private String nameShop;
	
	@Column(name= "domain")
	private String domain;
	
	@Column(name= "telephone1")
	private String telephone1;
	
	@Column(name= "telephone2")
	private String telephone2;
	
	@Column(name= "email1")
	private String email1;
	
	@Column(name= "email2")
	private String email2;
	
	@Column(name= "address1")
	private String address1;
	
	@Column(name= "address2")
	private String address2;
	
	@Column(name = "idTimeZone")
	private Long idTimeZone;
	
	@JoinColumn(name = "idTimeZone", referencedColumnName = "idTimeZone", insertable = false, updatable = false)
	@ManyToOne
	private TimeZone timeZone;

	public Settings() {
	}

	public Settings(Long idSettings, String nameShop, String domain, String telephone1, String telephone2,
			String email1, String email2, String address1, String address2, Long idTimeZone) {
		super();
		this.idSettings = idSettings;
		this.nameShop = nameShop;
		this.domain = domain;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
		this.email1 = email1;
		this.email2 = email2;
		this.address1 = address1;
		this.address2 = address2;
		this.idTimeZone = idTimeZone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSettings == null) ? 0 : idSettings.hashCode());
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
		Settings other = (Settings) obj;
		if (idSettings == null) {
			if (other.idSettings != null)
				return false;
		} else if (!idSettings.equals(other.idSettings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SettingsShop [idShop=" + idSettings + "]";
	}

	public Long getIdSettings() {
		return idSettings;
	}

	public void setIdSettings(Long idShop) {
		this.idSettings = idShop;
	}

	public String getNameShop() {
		return nameShop;
	}

	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
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

	public Long getIdTimeZone() {
		return idTimeZone;
	}

	public void setIdTimeZone(Long idTimeZone) {
		this.idTimeZone = idTimeZone;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
	
}
