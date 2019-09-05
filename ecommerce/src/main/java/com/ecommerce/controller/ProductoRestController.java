package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.entity.Products;
import com.ecommerce.service.ProductoService;

@RestController
public class ProductoRestController {

	private ProductoService proService;

	@Autowired
	public ProductoRestController(ProductoService proService) {
		this.proService = proService;
	}
	
	//CRUD

	// metodo insertar
	@RequestMapping(value = "/producto", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProducts(@RequestBody Products pro) {
//		Products prod = proService.saveProducts(pro);
		if(pro != null) {
		return new ResponseEntity<>(proService.saveProducts(pro), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(proService.saveProducts(pro), HttpStatus.BAD_REQUEST);
		}
	}

	// metodo consultar
	@ResponseStatus(code = HttpStatus.FOUND)//Debo crear una funcion para llamar este httpStatus
	@RequestMapping(value = "/producto", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Products> getProducts() {
		List<Products> list = proService.findAll();
		
		if(list != null) {
			return list;
		}else {
			error();
			return null;
		}
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Content doesn't exist or some parameters are invalid")
	public String error() {
		return "Error";
	}
	
	//metodo find by id
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
		
		Products pro = proService.findByIdProducts(id);
		if(pro != null) {
			return new ResponseEntity<>(proService.findByIdProducts(id), HttpStatus.FOUND);
		}else{
	        return new ResponseEntity<>(proService.findByIdProducts(id), HttpStatus.NOT_FOUND);
	    }
	}

	// metodo delete
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteProducts(@PathVariable("id") Long id) {
		String pro = proService.deletePro(id);
		
		if (pro.equalsIgnoreCase("ok")) {
			return new ResponseEntity<>(pro, HttpStatus.OK);
		} if(pro.equalsIgnoreCase("error")) {
			return new ResponseEntity<>(pro, HttpStatus.NO_CONTENT);
		}
		else {
			return null;
		}
//		proService.deletePro(id);
	}

	// metodo update
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateProducts(@RequestBody Products pro) {
//		Products prod = proService.updateProducts(pro);
		
		if(pro != null) {
			return new ResponseEntity<>(proService.updateProducts(pro), HttpStatus.OK);
		}else{
	        return new ResponseEntity<>(proService.updateProducts(pro), HttpStatus.BAD_REQUEST);
	    }
	}

	/// *******************************************
}
