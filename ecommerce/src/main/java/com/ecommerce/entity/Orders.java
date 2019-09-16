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
	private Date purchaseDate;
	
	@Column(name = "idBillingAddress")
	private Long idBillingAddress;

	@Column(name = "idOrderStatus")
	private Long idOrderStatus;
	
	@Column(name = "idClient")
	private Long idClient;
	
	@Column(name = "idInvoice")
	private Long idInvoice;
	
	@Column(name = "idPromotions")
	private Long idPromotions;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	private Set<Products> listProducts;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	private Set<OrdersDetail> listOrderStatus;
	
	@JoinColumn(name = "idOrderStatus", referencedColumnName = "idOrderStatus", insertable = false, updatable = false)
	@ManyToOne
	private OrderStatus orderStatus;
}
