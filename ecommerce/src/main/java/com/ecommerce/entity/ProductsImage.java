package com.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productImage")
public class ProductsImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProductImage")
	private Integer idImageProduct;
	@Column(name = "imageName")
	private String imageName;
	@Column(name = "idCombo")
	private Integer idCombo;
	@Column(name = "idProducts")
	private Integer idProduct;
	
	@ManyToOne
	@JoinColumn(name = "idProducts", insertable = false, updatable = false)
	private Products idProd;

	public ProductsImage(Integer idImageProduct, String imageName, Integer idCombo, Integer idProduct) {
		super();
		this.idImageProduct = idImageProduct;
		this.imageName = imageName;
		this.idCombo = idCombo;
		this.idProduct = idProduct;
	}
	
	public ProductsImage() {
		
	}

	public Integer getIdImageProduct() {
		return idImageProduct;
	}

	public void setIdImageProduct(Integer idImageProduct) {
		this.idImageProduct = idImageProduct;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(Integer idCombo) {
		this.idCombo = idCombo;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	
	
	
}
