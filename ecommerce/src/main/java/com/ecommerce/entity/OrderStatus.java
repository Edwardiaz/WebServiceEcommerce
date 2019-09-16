package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderStatus")
public class OrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOrderStatus")
	private Long idOrderStatus;

	@Column(name = "state")
	private String state;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "orderStatus", fetch = FetchType.EAGER)
	private Set<Orders> listOrderStatus;
	
	
}
