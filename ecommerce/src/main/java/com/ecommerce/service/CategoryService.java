package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Category;

public interface CategoryService {

	public Category saveCategory(Category cat);
	
	public List<Category> findAllCategory();
	
	public Category findByIdCategory(Long id);
	
	public void deleteCategory(Long id);
	
	public Category updateCategory(Category cat);
}
