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
@Table(name = "configProducts")
public class ConfigProducts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConfigProducts")
	private Long idConfigProducts;
	
	@Column(name = "nameAttribute")
	private String nameAttribute;
	
	@Column(name = "codeAttribute")
	private String codeAttribute;
	
	@Column(name= "visibility", columnDefinition = "BIT", length = 1)
	private boolean visibility;
	
	@Column(name = "idProducts")
	private Long idProducts;
	
	@Column(name = "idTypeAttribute")
	private Long idTypeAttribute;
	
	@OneToMany(mappedBy = "configProducts", fetch = FetchType.EAGER)
	private Set<ProductsConfigProducts> listProductsConfigProducts;
	
	@JoinColumn(name = "idTypeAttribute", referencedColumnName = "idTypeAttribute", insertable = false, updatable = false)
	@ManyToOne
	private TypeAttribute typeAttribute;

	public ConfigProducts() {
	}

	public ConfigProducts(Long idConfigProducts, String nameAttribute, String codeAttribute, boolean visibility,
			Long idProducts, Long idTypeAttribute) {
		super();
		this.idConfigProducts = idConfigProducts;
		this.nameAttribute = nameAttribute;
		this.codeAttribute = codeAttribute;
		this.visibility = visibility;
		this.idProducts = idProducts;
		this.idTypeAttribute = idTypeAttribute;
	}

	public Long getIdConfigProducts() {
		return idConfigProducts;
	}

	public void setIdConfigProducts(Long idConfigProducts) {
		this.idConfigProducts = idConfigProducts;
	}

	public String getNameAttribute() {
		return nameAttribute;
	}

	public void setNameAttribute(String nameAttribute) {
		this.nameAttribute = nameAttribute;
	}

	public String getCodeAttribute() {
		return codeAttribute;
	}

	public void setCodeAttribute(String codeAttribute) {
		this.codeAttribute = codeAttribute;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public Long getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(Long idProducts) {
		this.idProducts = idProducts;
	}

	public Long getIdTypeAttribute() {
		return idTypeAttribute;
	}

	public void setIdTypeAttribute(Long idTypeAttribute) {
		this.idTypeAttribute = idTypeAttribute;
	}
	
	
	
}
