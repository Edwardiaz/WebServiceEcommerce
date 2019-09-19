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
@Table(name = "configPromotions")
public class ConfigPromotions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConfigPromotions")
	private Long idConfigPromotions;

	@Column(name= "idPromotions")
	private Long idPromotions;
	
	@Column(name= "idProducts")
	private Long idProducts;
	
	@Column(name= "idCategory")
	private Long idCategory;
	
	@JoinColumn(name = "idProducts", referencedColumnName = "idProducts", insertable = false, updatable = false)
	@ManyToOne
	private Products products;
	
	@JoinColumn(name = "idCategory", referencedColumnName = "idCategory", insertable = false, updatable = false)
	@ManyToOne
	private Category category;
	
	@JoinColumn(name = "idPromotions", referencedColumnName = "idPromotions", insertable = false, updatable = false)
	@ManyToOne
	private Promotions promotions;

	public ConfigPromotions() {
	}

	public ConfigPromotions(Long idConfigPromotions, Long idPromotions, Long idProducts, Long idCategory) {
		super();
		this.idConfigPromotions = idConfigPromotions;
		this.idPromotions = idPromotions;
		this.idProducts = idProducts;
		this.idCategory = idCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConfigPromotions == null) ? 0 : idConfigPromotions.hashCode());
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
		ConfigPromotions other = (ConfigPromotions) obj;
		if (idConfigPromotions == null) {
			if (other.idConfigPromotions != null)
				return false;
		} else if (!idConfigPromotions.equals(other.idConfigPromotions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConfigPromotions [idConfigPromotions=" + idConfigPromotions + "]";
	}

	public Long getIdConfigPromotions() {
		return idConfigPromotions;
	}

	public void setIdConfigPromotions(Long idConfigPromotions) {
		this.idConfigPromotions = idConfigPromotions;
	}

	public Long getIdPromotions() {
		return idPromotions;
	}

	public void setIdPromotions(Long idPromotions) {
		this.idPromotions = idPromotions;
	}

	public Long getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(Long idProducts) {
		this.idProducts = idProducts;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	

}
