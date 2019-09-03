package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductoService;

public class CategoryProCatRestController {

	private CategoryService catService;
	
	private ProductsCategory proCatService;

	@Autowired
	public CategoryProCatRestController(CategoryService catService) {
		this.catService = catService;
	}
	
	@Autowired
	public CategoryProCatRestController(ProductsCategory proCatService) {
		this.proCatService = proCatService;
	}

	// metodo insertar
	@RequestMapping(value = "/categoria", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Category saveCategory(@RequestBody Category cat) {
		return catService.saveCategory(cat);
	}

	// metodo consultar
	@RequestMapping(value = "/categoria", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Category> getCategoria() {
		List<Category> list = catService.findAllCategory();
		return list;
	}

	// metodo find by id
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Category getProductById(@PathVariable("id") Long id) {
		return catService.findByIdCategory(id);
	}

	// metodo delete
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void deleteProducts(@PathVariable("id") Long id) {
		proService.delete(id);
	}

	//metodo update
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Products updateProducts(@RequestBody Products pro) {
		return proService.updateProducts(pro);
	}
	
	///*******************************************
}
