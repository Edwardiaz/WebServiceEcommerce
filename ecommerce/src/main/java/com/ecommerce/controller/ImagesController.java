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

import com.ecommerce.entity.ProductsImage;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IRetrieveImageService;

@RestController
@RequestMapping("/api")
public class ImagesController {

	private IRetrieveImageService retrieveService;
	private IGenericService genS;
	
	@Autowired
	public ImagesController(IRetrieveImageService retrieveService, IGenericService genS) {
		this.retrieveService = retrieveService;
		this.genS = genS;
	}
	
	@RequestMapping(value = "/imagen", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProImage(@RequestBody ProductsImage proima) {
		if(proima.getIdImageProduct() == null || proima.getIdImageProduct() == 0) {
		return new ResponseEntity<>(genS.saveObject(proima), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("ERROR AL GUARDAR", HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/imagen", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ProductsImage> findAllProImage() {
		List<ProductsImage> listProIma = retrieveService.findAllProImage();
		return listProIma;
	}
	
	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> userById(@PathVariable("id") Long id) {
		
		ProductsImage ima = retrieveService.findByIdImage(id);
	
		if (ima != null) {
			return new ResponseEntity<>(ima, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
