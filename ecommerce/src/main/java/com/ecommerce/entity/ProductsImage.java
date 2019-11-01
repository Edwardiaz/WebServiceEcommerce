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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "productImage")
public class ProductsImage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProductImage")
	private Long idImageProduct;
	@Column(name = "imageCode")
	private Integer imageCode;
	@Column(name = "imageName")
	private String imageName;
	@Column(name = "idCombo")
	private Integer idCombo;
	@Column(name = "idProducts")
	private Long idProduct;
	
	@JsonInclude
	@Transient
	private String url;
	
	@JoinColumn(name = "idProducts", insertable = false, updatable = false)
	@ManyToOne
	private Products idProd;
	
	@JoinColumn(name = "idCombo", insertable = false, updatable = false)
	@ManyToOne
	private Combo combo;
	
	public ProductsImage(Long idImageProduct, Integer imageCode, String imageName, Integer idCombo,
			Long idProduct, String url) {
		super();
		this.idImageProduct = idImageProduct;
		this.imageCode = imageCode;
		this.imageName = imageName;
		this.idCombo = idCombo;
		this.idProduct = idProduct;
		this.url = url;
	}

	public ProductsImage() {
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getIdImageProduct() {
		return idImageProduct;
	}

	public void setIdImageProduct(Long idImageProduct) {
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

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getImageCode() {
		return imageCode;
	}

	public void setImageCode(Integer imageCode) {
		this.imageCode = imageCode;
	}
	
}
