package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Products;

public interface InterfaceProductoDao extends JpaRepository<Products, Long>{
	
	public Products updateProducts(Products pro);
	
	public Products findByIdProducts(Long id);
	
	public String deletePro(Long id);
	
}
