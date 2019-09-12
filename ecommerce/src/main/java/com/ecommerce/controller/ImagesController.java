package com.ecommerce.controller;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.ProductsImage;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IRetrieveImageService;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.http.HttpHeaders;
//import com.technicalkeeda.bean.FileInfo;

@RestController
@RequestMapping("/api")
@MultipartConfig
public class ImagesController {

	private IRetrieveImageService retrieveService;
	private IGenericService genS;
	
	@Autowired
	public ImagesController(IRetrieveImageService retrieveService, IGenericService genS) {
		this.retrieveService = retrieveService;
		this.genS = genS;
	}
	
		@Autowired
		ServletContext context;
		
		@RequestMapping(value = "/imagen", method = RequestMethod.POST,headers=("content-type=multipart/*"), produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
	 public ResponseEntity<?> upload(@RequestParam("file") MultipartFile inputFile/*, @RequestBody ProductsImage prod*/) {
	  ProductsImage proImage = new ProductsImage();
	  HttpHeaders headers = new HttpHeaders();
	  if (!inputFile.isEmpty()) {
	   try{
	    String originalFilename = inputFile.getOriginalFilename();
//	    File destinationFile = new File(context.getRealPath("/WEB-INF/images")+  File.separator + originalFilename);
	    // C:\Users\Jorge.Diaz\Documents\GitHub\WebServiceEcommerce\ecommerce\src\main\webapp\WEB-INF\images
	    File destinationFile = new File("C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images" + File.separator + originalFilename);
	    inputFile.transferTo(destinationFile);
	    proImage.setImageName(destinationFile.getPath());
//	    proImage.setFileSize(inputFile.getSize());
	    headers.add("File Uploaded Successfully ", originalFilename);
	    System.out.println("dato exitoso, destino: "+destinationFile);
	    System.out.println("Nombre del archivo: "+originalFilename);
	    proImage.setIdImageProduct(null);//auto_increment
	    Object saveIma = genS.saveObject(proImage);
	    System.out.println("OBJETO:::::> "+saveIma);
	    return new ResponseEntity<>(proImage, headers, HttpStatus.OK);
	   } catch (Exception e) {    
		   System.out.println("Error mas: "+e);
	    return new ResponseEntity<>("Error: Invalid file", HttpStatus.BAD_REQUEST);
	   }
	  }else{
	   return new ResponseEntity<>("Error: Empty file",HttpStatus.BAD_REQUEST);
	  }
	 }
	
// ********************************************************************************************************************* \\
	
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
