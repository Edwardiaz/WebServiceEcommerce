package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Products;
	
public interface ProductoService {
	
	public Products saveProducts(Products pro);

	public List<Products> findAll();
	
	public Products findByIdProducts(Long id);
	
	public boolean deletePro(Long id);
	
	public Products updateProducts(Products pro);
	
	public Products saveProductsCate(Products pro);
}
