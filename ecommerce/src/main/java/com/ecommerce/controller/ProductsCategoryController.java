package com.ecommerce.controller;

import java.util.List;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.ProductsCategoryDao;
import com.ecommerce.entity.ProductsCategory;




public class ProductsCategoryController {

//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public String handler(Model m) {
//		return "index";
//	}
	
	@RequestMapping(value = "/proCat", method = RequestMethod.POST)
	public String saveProCat
	(@RequestParam(value = "idProducts") int idProducts,
	 @RequestParam(value = "idCategory") int idCategory) {
		ProductsCategoryDao proCatDao = new ProductsCategoryDao();
		ProductsCategory proCat = new ProductsCategory();
		
		proCat.setIdProducts(idProducts);
		proCat.setIdCategory(idCategory);
		proCatDao.savePC(proCat);
		return "index2";
	}
	
	@RequestMapping("/listProCat")
	public String findAllProCat(Model m) {
		ProductsCategoryDao proCatDao = new ProductsCategoryDao();
		List<ProductsCategory> listProCat = proCatDao.findAllProCat();
		m.addAttribute("listProCat", listProCat);
		return "ShowProCat";
	}
	
	@RequestMapping(value = "/deleteprocat/{idProductsCategory}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("idProductsCategory") int id, Model m) {
		ProductsCategoryDao proCatDao = new ProductsCategoryDao();
		proCatDao.deleteProCat(id);
		List<ProductsCategory> listProCat = proCatDao.findAllProCat();
		m.addAttribute("listProCat", listProCat);
		return "ShowProCat";
	}
	
	@RequestMapping(value = "updateProCat", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("idProductsCategory") int id, Model m) {
		ProductsCategoryDao proCatDao = new ProductsCategoryDao();
		proCatDao.updateProCat(id);
		List<ProductsCategory> listProCat = proCatDao.findAllProCat();
		m.addAttribute("listProCat", listProCat);
		return "ShowProCat";
	}
	
	@RequestMapping(value="/updatePro/{idProducts}", method = RequestMethod.GET)
	public String findByIdProducto(@PathVariable("idProducts") int id, Model m){
		ProductsCategoryDao proCatDao = new ProductsCategoryDao();
		proCatDao.findByIdProCat(id);
		return "updateProCat";
	}
}
