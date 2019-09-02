package com.ecommerce.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductsDao;
import com.ecommerce.entity.Category;


public class CategoryController {

//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public String handler(Model m) {
//		
//		return "index";
//	}
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String saveProducts
	(@RequestParam(value = "nameCategory") String nameCategory,
	 @RequestParam(value = "description") String description,
	 @RequestParam(value = "idCategoryPadre") int idCategoryPadre) {
		CategoryDao catDao = new CategoryDao();
		Category category = new Category();
		
		category.setNameCategory(nameCategory);
		category.setDescription(description);
		category.setIdCategoryPadre(idCategoryPadre);
		catDao.saveCategory(category);
		
		return "index2";
	}
	
	@RequestMapping("/listCat")
	public String findAllCategories(Model m) {
		CategoryDao catDao = new CategoryDao();
		List<Category> listCat = catDao.findAllCategory();
		m.addAttribute("listCat", listCat);
		
		return "ShowCategory";
	}
	
	@RequestMapping(value = "/deletecat/{idCategory}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("idCategory") int id, Model m) {
		CategoryDao catDao = new CategoryDao();
		catDao.deleteCategory(id);
		List<Category> listCat = catDao.findAllCategory();
		m.addAttribute("listCat", listCat);
		
		return "showCategory";
	}
	
	@RequestMapping(value = "updatecategory", method = RequestMethod.PUT)
	public String updateCategory(@PathVariable("idCategory") int id, Model m) {
		CategoryDao catDao = new CategoryDao();
		catDao.updateCategory(id);
		List<Category> listCat = catDao.findAllCategory();
		m.addAttribute("listCat", listCat);
		return "showCategory";
	}
	
	@RequestMapping(value="/updatePro/{idCategory}", method = RequestMethod.GET)
	public String findByIdProducto(@PathVariable("idCategory") int id, Model m){
		ProductsDao proDao = new ProductsDao();
		proDao.findByIdProducts(id);
		return "updateProducto";
	}
}
