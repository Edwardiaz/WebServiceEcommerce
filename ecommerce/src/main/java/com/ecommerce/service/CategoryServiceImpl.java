package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.InterfaceCategoryDao;
import com.ecommerce.dao.InterfaceProCatDao;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.ProductsCategory;

@Service
public class CategoryServiceImpl implements CategoryService{

	private InterfaceCategoryDao interCatDao;
	
	private InterfaceProCatDao interProCatDao;
	
	@Autowired
	public CategoryServiceImpl(InterfaceCategoryDao interCatDao, InterfaceProCatDao interProCatDao) {
		this.interCatDao = interCatDao;
		this.interProCatDao = interProCatDao;
	}
	//CRUD

	@Override
	public Category saveCategory(Category cat) {
		return interCatDao.saveCategory(cat);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAllCategory() {
		return interCatDao.findAllCategory();
	}

	@Override
	@Transactional(readOnly = true)
	public Category findByIdCategory(Long id) {
		return interCatDao.findByIdCategory(id);
	}

	@Override
	public boolean deleteCategory(Long id) {
		return interCatDao.deteleCategory(id);
	}

	@Override
	public Category updateCategory(Category cat) {
		return interCatDao.updateCategory(cat);
	}
	// ********************************************* \\

	@Override
	public ProductsCategory saveProductsCategory(ProductsCategory cat) {
		return interProCatDao.saveProCat(cat);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductsCategory> findAllProductsCategory() {
		return interProCatDao.findAllProCat();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductsCategory findByIdProductsCategory(Long id) {
		return interProCatDao.findByIdProCat(id);
	}

	@Override
	public boolean deleteProductsCategory(Long id) {
		return interProCatDao.deleteProCat(id);
	}

	@Override
	public ProductsCategory updateProductsCategory(ProductsCategory cat) {
		return interProCatDao.updateProCat(cat);
	}
	
	
}
