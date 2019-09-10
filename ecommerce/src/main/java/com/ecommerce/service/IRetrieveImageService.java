package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.ProductsImage;

public interface IRetrieveImageService {

	public List<ProductsImage> findAllProImage();
	
	public ProductsImage findByIdImage(Long id);
}
