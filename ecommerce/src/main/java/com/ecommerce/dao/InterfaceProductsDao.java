package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.Products;

public interface InterfaceProductsDao {
	
	public Products updateProduct(Products pro);

	public Products findByIdProduct(Long id);

	public Products saveProduct(Products pro);

	public List<Products> findAllProduct();

	public boolean deleteProduct(Long id);

//	public Products saveProductsCate(Products pro);
}
