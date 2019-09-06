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
@Table(name = "clientCategoryClient")
public class ClientCategoryClient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClientCategoryClientl")
	private Long idClientCategoryClient;
	
	@Column(name= "idClient")
	private Long idClient;
	
	@Column(name= "idCategoryClient")
	private Long idCategoryClient;
	
	@JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable=false, updatable = false)
    @ManyToOne
    private Client client;
	
	@JoinColumn(name = "idCategoryClient", referencedColumnName = "idCategoryClient", insertable=false, updatable = false)
    @ManyToOne
    private CategoryClient categoryClient;

	public ClientCategoryClient() {
	}

	public ClientCategoryClient(Long idClientCategoryClient, Long idClient, Long idCategoryClient) {
		super();
		this.idClientCategoryClient = idClientCategoryClient;
		this.idClient = idClient;
		this.idCategoryClient = idCategoryClient;
	}

	public Long getIdClientCategoryClient() {
		return idClientCategoryClient;
	}

	public void setIdClientCategoryClient(Long idClientCategoryClient) {
		this.idClientCategoryClient = idClientCategoryClient;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getIdCategoryClient() {
		return idCategoryClient;
	}

	public void setIdCategoryClient(Long idCategoryClient) {
		this.idCategoryClient = idCategoryClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClientCategoryClient == null) ? 0 : idClientCategoryClient.hashCode());
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
		ClientCategoryClient other = (ClientCategoryClient) obj;
		if (idClientCategoryClient == null) {
			if (other.idClientCategoryClient != null)
				return false;
		} else if (!idClientCategoryClient.equals(other.idClientCategoryClient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientCategoryClient [idClientCategoryClient=" + idClientCategoryClient + "]";
	}
	
	
}
