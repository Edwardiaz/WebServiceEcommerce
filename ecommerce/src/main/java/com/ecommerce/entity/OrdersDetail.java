package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Date dateOfPurchase;
	
	@Column(name = "paymentType")
	private String paymentType;
	
	@Column(name = "subTotal")
	private Double subTotal;
	
	@Column(name = "totalPrice")
	private Double totalPrice;
	
	@Column(name = "shippingDate")
	private Date shippingDate;
	
	@Column(name = "shippingAddress")
	private String shippingAddress;
	
	@Column(name = "supplier")
	private String supplier;
	
	@Column(name = "idOrders")
	private Long idOrders;
	
	
}
