package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "idCategoryPadre", nullable = true)
	private Integer idCategoryPadre;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<ProductsCategory> productsCategorySet;
	
	/* realcion especial*/
	@JoinColumn(name = "idCategoryPadre", insertable = false, updatable = false)
	@ManyToOne
	private Category idCatPadre;
	
	@OneToMany(mappedBy = "idCatPadre", fetch = FetchType.EAGER)
	private Set<Category> categoriaSet;
	/*Termina relacion especial*/
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Set<ConfigPromotions> listConfigPromotions;
	
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

	public Integer getIdCategoryPadre() {
		return idCategoryPadre;
	}

	public void setIdCategoryPadre(Integer idCategoryPadre) {
		this.idCategoryPadre = idCategoryPadre;
	}

//	public Set<ProductsCategory> getProductsCategorySet() {
//		return productsCategorySet;
//	}
//
//	public void setProductsCategorySet(Set<ProductsCategory> productsCategorySet) {
//		this.productsCategorySet = productsCategorySet;
//	}
	
}
