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

@Entity
@Table(name = "combo")
public class Combo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCombo")
	private Long idCombo;
	
	@Column(name = "nameCombo")
	private String nameCombo;
	
	@Column(name = "codeCombo")
	private String codeCombo;
	
	@Column(name = "priceCombo")
	private Double priceCombo;
	
	@Column(name = "discountPriceCombo")
	private Double discountPriceCombo;
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToMany(mappedBy = "combo", fetch = FetchType.EAGER)
	private Set<ComboProducts> listComboProducts;

	@OneToMany(mappedBy = "combo", fetch = FetchType.EAGER)
	private Set<ProductsImage> listProductsImage;
	
	public Combo() {
	}

	public Combo(Long idCombo, String nameCombo, String codeCombo, Double priceCombo, Double discountPriceCombo,
			Date date) {
		super();
		this.idCombo = idCombo;
		this.nameCombo = nameCombo;
		this.codeCombo = codeCombo;
		this.priceCombo = priceCombo;
		this.discountPriceCombo = discountPriceCombo;
		this.date = date;
	}

	public Long getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(Long idCombo) {
		this.idCombo = idCombo;
	}

	public String getNameCombo() {
		return nameCombo;
	}

	public void setNameCombo(String nameCombo) {
		this.nameCombo = nameCombo;
	}

	public String getCodeCombo() {
		return codeCombo;
	}

	public void setCodeCombo(String codeCombo) {
		this.codeCombo = codeCombo;
	}

	public Double getPriceCombo() {
		return priceCombo;
	}

	public void setPriceCombo(Double priceCombo) {
		this.priceCombo = priceCombo;
	}

	public Double getDiscountPriceCombo() {
		return discountPriceCombo;
	}

	public void setDiscountPriceCombo(Double discountPriceCombo) {
		this.discountPriceCombo = discountPriceCombo;
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
		result = prime * result + ((idCombo == null) ? 0 : idCombo.hashCode());
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
		Combo other = (Combo) obj;
		if (idCombo == null) {
			if (other.idCombo != null)
				return false;
		} else if (!idCombo.equals(other.idCombo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Combo [idCombo=" + idCombo + "]";
	}
	
	
}
