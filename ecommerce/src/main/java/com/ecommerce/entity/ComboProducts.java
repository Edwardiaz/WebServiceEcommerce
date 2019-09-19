package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comboProducts")
public class ComboProducts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idComboProducts")
	private Long idComboProducts;
	
	@Column(name = "idCombo")
	private Long idCombo;
	
	@Column(name = "idProducts")
	private Long idProducts;
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@JoinColumn(name = "idCombo", referencedColumnName = "idCombo", insertable = false, updatable = false)
	@ManyToOne
	private Combo combo;
	
	@JoinColumn(name = "idProducts", referencedColumnName = "idProducts", insertable = false, updatable = false)
	@ManyToOne
	private Products products;

	public ComboProducts() {
	}

	public ComboProducts(Long idComboProducts, Long idCombo, Long idProducts, Date date) {
		super();
		this.idComboProducts = idComboProducts;
		this.idCombo = idCombo;
		this.idProducts = idProducts;
		this.date = date;
	}

	public Long getIdComboProducts() {
		return idComboProducts;
	}

	public void setIdComboProducts(Long idComboProducts) {
		this.idComboProducts = idComboProducts;
	}

	public Long getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(Long idCombo) {
		this.idCombo = idCombo;
	}

	public Long getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(Long idProducts) {
		this.idProducts = idProducts;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idComboProducts == null) ? 0 : idComboProducts.hashCode());
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
		ComboProducts other = (ComboProducts) obj;
		if (idComboProducts == null) {
			if (other.idComboProducts != null)
				return false;
		} else if (!idComboProducts.equals(other.idComboProducts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComboProducts [idComboProducts=" + idComboProducts + "]";
	}
	
	
}
