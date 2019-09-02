package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.InterfaceCategoryDao;
import com.ecommerce.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	private InterfaceCategoryDao interCatDao;
	
	@Autowired
	public CategoryServiceImpl(InterfaceCategoryDao interCatDao) {
		this.interCatDao = interCatDao;
	}

	@Override
	public Category saveCategory(Category cat) {
		return interCatDao.saveCategory(cat);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByIdCategory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category updateCategory(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
