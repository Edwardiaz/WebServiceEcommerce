package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.Category;

public interface InterfaceCategoryDao{
	
	public Category saveCategory(Category cat);
	
	public List<Category>findAllCategory();
	
	public Category findByIdCategory(Long id);
	
	public void deteleCategory(Long id);

	public Category updateCategory(Category cat);
}
