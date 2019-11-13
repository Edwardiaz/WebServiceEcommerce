package com.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "productsCategory")
public class ProductsCategory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idProductCategory")
	private Long idProductsCategory;
	@Column(name = "idProducts")
	private Long idPro;
	@Column(name = "idCategory")
	private Long idCat;
	
	
	@JoinColumn(name = "idCategory", insertable = false, updatable = false)
	@ManyToOne
	private Category category;

	@JoinColumn(name = "idProducts", insertable = false, updatable = false)
	@ManyToOne
	private Products products;
	
	public ProductsCategory() {
		
	}
	
	public ProductsCategory(Long idProductsCategory, Long idPro, Long idCat) {
		super();
		this.idProductsCategory = idProductsCategory;
		this.idPro = idPro;
		this.idCat = idCat;
	}

	public Long getIdProductsCategory() {
		return idProductsCategory;
	}

	public void setIdProductsCategory(Long idProductsCategory) {
		this.idProductsCategory = idProductsCategory;
	}

	public Long getIdPro() {
		return idPro;
	}

	public void setIdPro(Long idPro) {
		this.idPro = idPro;
	}

	public Long getIdCat() {
		return idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public Products getProducts() {
//		return products;
//	}
//
//	public void setProducts(Products products) {
//		this.products = products;
//	}

//	public ProductsCategory(Long idProductsCategory) {
//		this.idProductsCategory = idProductsCategory;
//	}

	
	
}
