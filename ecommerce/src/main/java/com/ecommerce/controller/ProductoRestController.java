package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Products;
import com.ecommerce.service.ProductoService;



@RestController
public class ProductoRestController {

	private ProductoService proService;

	@Autowired
	public ProductoRestController(ProductoService proService) {
		this.proService = proService;
	}

	// metodo insertar
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid ")
	@RequestMapping(value = "/producto", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Products saveProducts(@RequestBody Products pro) {
		return proService.saveProducts(pro);
	}

	// metodo consultar
	@RequestMapping(value = "/producto", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Products> getProducts() {
		List<Products> list = proService.findAll();
		return list;
	}

	// metodo find by id
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Products getProductById(@PathVariable("id") Long id) {
		return proService.findByIdProducts(id);
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
