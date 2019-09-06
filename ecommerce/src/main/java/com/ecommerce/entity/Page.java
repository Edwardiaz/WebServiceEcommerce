package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "page")
public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPage")
	private Long idPage;
	
	@Column(name= "title")
	private String title;
	
	@Column(name= "contenido")
	private String contenido;
	
	@Column(name = "dateCreate")
	//@Temporal(TemporalType.DATE)
	private String dateCreate;
	
	@Column(name = "dateUpdate")
	//@Temporal(TemporalType.DATE)
	private String dateUpdate;
	
	@Column(name= "domain")
	private String domain;
	
	@Column(name= "status", columnDefinition = "BIT", length = 1)
	private boolean status;
	
	@Column(name= "keyURL")
	private String keyURL;
	
	@Column(name= "metaTitle")
	private String metaTitle;
	
	@Column(name= "metaKeyWords")
	private String metaKeyWords;
	
	@Column(name= "metaDescriptions")
	private String metaDescriptions;
	
	@Column(name= "idUsers")
	private Long idUsers;
	
	@JoinColumn(name = "idUsers", insertable=false, updatable = false)
    @ManyToOne
    private Users users;

	

	public Page(Long idPage, String title, String contenido, String dateCreate, String dateUpdate, String domain,
			boolean status, String keyURL, String metaTitle, String metaKeyWords, String metaDescriptions,
			Long idUsers) {
		super();
		this.idPage = idPage;
		this.title = title;
		this.contenido = contenido;
		this.dateCreate = dateCreate;
		this.dateUpdate = dateUpdate;
		this.domain = domain;
		this.status = status;
		this.keyURL = keyURL;
		this.metaTitle = metaTitle;
		this.metaKeyWords = metaKeyWords;
		this.metaDescriptions = metaDescriptions;
		this.idUsers = idUsers;
	}

	public Page() {
	}

	public Long getIdPage() {
		return idPage;
	}

	public void setIdPage(Long idPage2) {
		this.idPage = idPage2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getKeyURL() {
		return keyURL;
	}

	public void setKeyURL(String keyURL) {
		this.keyURL = keyURL;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeyWords() {
		return metaKeyWords;
	}

	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}

	public String getMetaDescriptions() {
		return metaDescriptions;
	}

	public void setMetaDescriptions(String metaDescriptions) {
		this.metaDescriptions = metaDescriptions;
	}



	public Long getIdUsers() {
		return idUsers;
	}

	public void setId_Users(Long idUsers) {
		this.idUsers = idUsers;
	}
	
	

//	public Users getUsers() {
//		return users;
//	}
//
//	public void setUsers(Users users) {
//		this.users = users;
//	}

	public String getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public void setIdUsers(Long idUsers) {
		this.idUsers = idUsers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPage == null) ? 0 : idPage.hashCode());
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
		Page other = (Page) obj;
		if (idPage == null) {
			if (other.idPage != null)
				return false;
		} else if (!idPage.equals(other.idPage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Page [idPage=" + idPage + "]";
	}

	
	
}
