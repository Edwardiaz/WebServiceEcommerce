package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.ProductsImage;

public interface InterfaceRetrieveImageDao {

	public List<ProductsImage> findAllProImage();
	
	public ProductsImage findByIdImage(Long id);
}
