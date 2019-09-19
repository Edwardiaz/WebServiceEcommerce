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
@Table(name = "productsSupplier")
public class ProductsSupplier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProductSupplier")
	private Long idProductSupplier;

	@Column(name = "idProducts")
	private Long idProducts;

	@Column(name = "idSupplier")
	private Long idSupplier;

	@JoinColumn(name = "idProducts", referencedColumnName = "idProducts", insertable = false, updatable = false)
	@ManyToOne
	private Products products;

	@JoinColumn(name = "idSupplier", referencedColumnName = "idSupplier", insertable = false, updatable = false)
	@ManyToOne
	private Supplier supplier;

	public ProductsSupplier() {
	}

	public ProductsSupplier(Long idProductSupplier, Long idProducts, Long idSupplier) {
		super();
		this.idProductSupplier = idProductSupplier;
		this.idProducts = idProducts;
		this.idSupplier = idSupplier;
	}

	public Long getIdProductSupplier() {
		return idProductSupplier;
	}

	public void setIdProductSupplier(Long idProductSupplier) {
		this.idProductSupplier = idProductSupplier;
	}

	public Long getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(Long idProducts) {
		this.idProducts = idProducts;
	}

	public Long getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(Long idSupplier) {
		this.idSupplier = idSupplier;
	}

}
