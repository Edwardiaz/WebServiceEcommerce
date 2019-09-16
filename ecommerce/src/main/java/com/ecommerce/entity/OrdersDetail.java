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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordersDetail")
public class OrdersDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOrdersDetails")
	private Long idOrdersDetails;

	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productQuantity")
	private Integer productQuantity;
	
	@Column(name = "productPrice")
	private Double productPrice;
	
	@Column(name = "discounts")
	private Double discounts;
	
	@Column(name = "taxes")
	private Double taxes;
	
	@Column(name = "dateOfPurchase")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfPurchase;
	
	@Column(name = "paymentType")
	private String paymentType;
	
	@Column(name = "subTotal")
	private Double subTotal;
	
	@Column(name = "totalPrice")
	private Double totalPrice;
	
	@Column(name = "shippingDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippingDate;
	
	@Column(name = "shippingAddress")
	private String shippingAddress;
	
	@Column(name = "supplier")
	private String supplier;
	
	@Column(name = "idOrders")
	private Long idOrders;
	
	@JoinColumn(name = "idOrders", referencedColumnName = "idOrders", insertable = false, updatable = false)
	@ManyToOne
	private Orders ordersD;

	public OrdersDetail() {
	}

	public OrdersDetail(Long idOrdersDetails, String productName, Integer productQuantity, Double productPrice,
			Double discounts, Double taxes, Date dateOfPurchase, String paymentType, Double subTotal, Double totalPrice,
			Date shippingDate, String shippingAddress, String supplier, Long idOrders) {
		super();
		this.idOrdersDetails = idOrdersDetails;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.discounts = discounts;
		this.taxes = taxes;
		this.dateOfPurchase = dateOfPurchase;
		this.paymentType = paymentType;
		this.subTotal = subTotal;
		this.totalPrice = totalPrice;
		this.shippingDate = shippingDate;
		this.shippingAddress = shippingAddress;
		this.supplier = supplier;
		this.idOrders = idOrders;
	}

	public Long getIdOrdersDetails() {
		return idOrdersDetails;
	}

	public void setIdOrdersDetails(Long idOrdersDetails) {
		this.idOrdersDetails = idOrdersDetails;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Double discounts) {
		this.discounts = discounts;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Long getIdOrders() {
		return idOrders;
	}

	public void setIdOrders(Long idOrders) {
		this.idOrders = idOrders;
	}
	
	
}
