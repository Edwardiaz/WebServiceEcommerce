package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategory")
	private Long idCategory;
	@Column(name = "nameCategory")
	private String nameCategory;
	@Column(name = "description")
	private String description;
	@Column(name = "idCategoryPadre")
	private int idCategoryPadre;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<ProductsCategory> productsCategorySet;
	
	public Category(){
	}
	
	public Category(Long idCategory, String nameCategory, String description, int idCategoryPadre) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.description = description;
		this.idCategoryPadre = idCategoryPadre;
	}

	public Category(Long idCategory) {
		this.idCategory = idCategory;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdCategoryPadre() {
		return idCategoryPadre;
	}

	public void setIdCategoryPadre(int idCategoryPadre) {
		this.idCategoryPadre = idCategoryPadre;
	}

	public Set<ProductsCategory> getProductsCategorySet() {
		return productsCategorySet;
	}

	public void setProductsCategorySet(Set<ProductsCategory> productsCategorySet) {
		this.productsCategorySet = productsCategorySet;
	}
	
}
