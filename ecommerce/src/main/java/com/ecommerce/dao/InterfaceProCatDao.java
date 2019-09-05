package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.ProductsCategory;

public interface InterfaceProCatDao{

	public ProductsCategory updateProCat(ProductsCategory pro);

	public ProductsCategory findByIdProCat(Long id);

	public ProductsCategory saveProCat(ProductsCategory cat);

	public List<ProductsCategory> findAllProCat();

	public String deleteProCat(Long id);

	
}
