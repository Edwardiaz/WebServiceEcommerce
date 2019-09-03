package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Category> findAllCategory() {
		return interCatDao.findAllCategory();
	}

	@Override
	public Category findByIdCategory(Long id) {
		return interCatDao.findByIdCategory(id);
	}

	@Override
	public void deleteCategory(Long id) {
		interCatDao.deteleCategory(id);
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
	public List<ProductsCategory> findAllProductsCategory() {
		return interProCatDao.findAllProCat();
	}

	@Override
	public ProductsCategory findByIdProductsCategory(Long id) {
		return interProCatDao.findByIdProCat(id);
	}

	@Override
	public void deleteProductsCategory(Long id) {
		interProCatDao.deleteProCat(id);
	}

	@Override
	public ProductsCategory updateProductsCategory(ProductsCategory cat) {
		return interProCatDao.updateProCat(cat);
	}
	
	
}
