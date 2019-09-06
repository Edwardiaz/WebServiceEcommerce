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
@Table(name = "categoryClient")
public class CategoryClient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoryClient")
	private Long idCategoryClient;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;
	
	@Column(name= "idParentCategoryClient")
	private Long idParentCategoryClient; //Circular relation
	
	@OneToMany(mappedBy = "categoryClient", fetch = FetchType.EAGER)
	private Set<ClientCategoryClient> listClientCategoryClient;
	
	//Autorelational mapping 
	@JoinColumn(name = "idParentCategoryClient", referencedColumnName = "idParentCategoryClient", insertable=false, updatable = false)
    @ManyToOne
    private CategoryClient categoryClient;
	
	@OneToMany(mappedBy = "categoryClient", fetch = FetchType.EAGER)
	private Set<CategoryClient> listCategoryClient;
	//Autorelational mapping 

	public CategoryClient() {
	}
	
	public CategoryClient(Long idCategoryClient, String name, String description, Long idParentCategoryClient) {
		super();
		this.idCategoryClient = idCategoryClient;
		this.name = name;
		this.description = description;
		this.idParentCategoryClient = idParentCategoryClient;
	}

	public Long getIdCategoryClient() {
		return idCategoryClient;
	}

	public void setIdCategoryClient(Long idCategoryClient) {
		this.idCategoryClient = idCategoryClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdParentCategoryClient() {
		return idParentCategoryClient;
	}

	public void setIdParentCategoryClient(Long idParentCategoryClient) {
		this.idParentCategoryClient = idParentCategoryClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoryClient == null) ? 0 : idCategoryClient.hashCode());
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
		CategoryClient other = (CategoryClient) obj;
		if (idCategoryClient == null) {
			if (other.idCategoryClient != null)
				return false;
		} else if (!idCategoryClient.equals(other.idCategoryClient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryClient [idCategoryClient=" + idCategoryClient + "]";
	}
	
	
}
