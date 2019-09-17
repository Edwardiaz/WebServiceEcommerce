package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInvoice")
	private Long idInvoice;
	
	@Column(name= "invoiceCode")
	private String invoiceCode;
	
	@Column(name= "dateInvoice")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInvoice;
	
	@Column(name= "nameStore")
	private String nameStore;
	
	@Column(name= "idClient")
	private Long idClient;
	
	@Column(name= "playmentDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date playmentDate;
	
	@JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable=false, updatable = false)
    @ManyToOne
    private Client client;
	
	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
	private Set<Orders> listOrders;
	
	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
	private Set<InvoiceDetail> listInvoiceDetail;

	public Invoice(Long idInvoice, String invoiceCode, Date dateInvoice, String nameStore, Long idClient,
			Date playmentDate) {
		super();
		this.idInvoice = idInvoice;
		this.invoiceCode = invoiceCode;
		this.dateInvoice = dateInvoice;
		this.nameStore = nameStore;
		this.idClient = idClient;
		this.playmentDate = playmentDate;
	}

	public Invoice() {
	}

	public Long getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Long idInvoice) {
		this.idInvoice = idInvoice;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public Date getDateInvoice() {
		return dateInvoice;
	}

	public void setDateInvoice(Date dateInvoice) {
		this.dateInvoice = dateInvoice;
	}

	public String getNameStore() {
		return nameStore;
	}

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Date getPlaymentDate() {
		return playmentDate;
	}

	public void setPlaymentDate(Date playmentDate) {
		this.playmentDate = playmentDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInvoice == null) ? 0 : idInvoice.hashCode());
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
		Invoice other = (Invoice) obj;
		if (idInvoice == null) {
			if (other.idInvoice != null)
				return false;
		} else if (!idInvoice.equals(other.idInvoice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [idInvoice=" + idInvoice + "]";
	}
	
}
