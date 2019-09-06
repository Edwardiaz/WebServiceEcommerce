package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoiceDetail")
public class InvoiceDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInvoiceDetail")
	private Long idInvoiceDetail;
	
	@Column(name= "invoiceDate")
	private Date invoiceDate;
	
	@Column(name= "quantity")
	private Integer quantity;
	
	@Column(name= "price")
	private Double price;
	
	@Column(name= "subTotal")
	private Double subTotal;
	
	@Column(name= "tax")
	private Double tax;
	
	@Column(name= "discount")
	private Double discount;
	
	@Column(name= "totalPrice")
	private Double totalPrice;
	
	@Column(name= "idInvoice")
	private Long idInvoice;
	
	@JoinColumn(name = "idInvoice", referencedColumnName = "idInvoice", insertable=false, updatable = false)
    @ManyToOne
    private Invoice invoice;

	public InvoiceDetail(Long idInvoiceDetail, Date invoiceDate, Integer quantity, Double price, Double subTotal,
			Double tax, Double discount, Double totalPrice, Long idInvoice) {
		super();
		this.idInvoiceDetail = idInvoiceDetail;
		this.invoiceDate = invoiceDate;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
		this.tax = tax;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.idInvoice = idInvoice;
	}

	public InvoiceDetail() {
	}

	public Long getIdInvoiceDetail() {
		return idInvoiceDetail;
	}

	public void setIdInvoiceDetail(Long idInvoiceDetail) {
		this.idInvoiceDetail = idInvoiceDetail;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Long idInvoice) {
		this.idInvoice = idInvoice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInvoiceDetail == null) ? 0 : idInvoiceDetail.hashCode());
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
		InvoiceDetail other = (InvoiceDetail) obj;
		if (idInvoiceDetail == null) {
			if (other.idInvoiceDetail != null)
				return false;
		} else if (!idInvoiceDetail.equals(other.idInvoiceDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [idInvoiceDetail=" + idInvoiceDetail + "]";
	}
	
	
}
