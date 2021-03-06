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
@Table(name = "orders")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOrders")
	private Long idOrders;
	
	@Column(name = "orderCode")
	private String orderCode;
	
	@Column(name = "purchaseDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;
	
	@Column(name = "idBillingAddress")
	private Long idBillingAddress;

	@Column(name = "idOrderStatus")
	private Long idOrderStatus;

	@Column(name = "idInvoice")
	private Long idInvoice;
	
	@Column(name = "idPromotions")
	private Long idPromotions;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	private Set<Products> listProducts;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	private Set<OrdersDetail> listOrderStatus;
	
	@JoinColumn(name = "idOrderStatus", /*referencedColumnName = "idOrderStatus", */insertable = false, updatable = false)
	@ManyToOne
	private OrderStatus orderStatus;
	
	@JoinColumn(name = "idPromotions", referencedColumnName = "idPromotions", insertable = false, updatable = false)
	@ManyToOne
	private Promotions promotions;

	public Orders() {
		
	}
	
	@JoinColumn(name = "idInvoice", referencedColumnName = "idInvoice", insertable = false, updatable = false)
	@ManyToOne
	private Invoice invoice;
	
	@JoinColumn(name = "idBillingAddress", referencedColumnName = "idBillingAddress", insertable = false, updatable = false)
	@ManyToOne
	private BillingAddress billingAddress;


	public Orders(Long idOrders, String orderCode, Date purchaseDate, Long idBillingAddress, Long idOrderStatus,
			Long idInvoice, Long idPromotions) {

		super();
		this.idOrders = idOrders;
		this.orderCode = orderCode;
		this.purchaseDate = purchaseDate;
		this.idBillingAddress = idBillingAddress;
		this.idOrderStatus = idOrderStatus;
		this.idInvoice = idInvoice;
		this.idPromotions = idPromotions;
	}


	public Long getIdOrders() {
		return idOrders;
	}


	public void setIdOrders(Long idOrders) {
		this.idOrders = idOrders;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Long getIdBillingAddress() {
		return idBillingAddress;
	}


	public void setIdBillingAddress(Long idBillingAddress) {
		this.idBillingAddress = idBillingAddress;
	}


	public Long getIdOrderStatus() {
		return idOrderStatus;
	}


	public void setIdOrderStatus(Long idOrderStatus) {
		this.idOrderStatus = idOrderStatus;
	}


	public Long getIdInvoice() {
		return idInvoice;
	}


	public void setIdInvoice(Long idInvoice) {
		this.idInvoice = idInvoice;
	}


	public Long getIdPromotions() {
		return idPromotions;
	}


	public void setIdPromotions(Long idPromotions) {
		this.idPromotions = idPromotions;
	}

	
}
