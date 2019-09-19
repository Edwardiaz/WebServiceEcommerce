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
@Table(name = "productsConfigProducts")
public class ProductsConfigProducts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProductsConfigProducts")
	private Long idProductsConfigProducts;
	
	@Column(name = "idProducts")
	private Long idProducts;
	
	@Column(name = "idConfigProducts")
	private Long idConfigProducts;
	
	@JoinColumn(name = "idProducts", referencedColumnName = "idProducts", insertable = false, updatable = false)
	@ManyToOne
	private Products products;
	
	@JoinColumn(name = "idConfigProducts", referencedColumnName = "idConfigProducts", insertable = false, updatable = false)
	@ManyToOne
	private ConfigProducts configProducts;

	public ProductsConfigProducts() {
	}

	public ProductsConfigProducts(Long idProductsConfigProducts, Long idProducts, Long idConfigProducts) {
		super();
		this.idProductsConfigProducts = idProductsConfigProducts;
		this.idProducts = idProducts;
		this.idConfigProducts = idConfigProducts;
	}

	public Long getIdProductsConfigProducts() {
		return idProductsConfigProducts;
	}

	public void setIdProductsConfigProducts(Long idProductsConfigProducts) {
		this.idProductsConfigProducts = idProductsConfigProducts;
	}

	public Long getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(Long idProducts) {
		this.idProducts = idProducts;
	}

	public Long getIdConfigProducts() {
		return idConfigProducts;
	}

	public void setIdConfigProducts(Long idConfigProducts) {
		this.idConfigProducts = idConfigProducts;
	}
	
	
}
