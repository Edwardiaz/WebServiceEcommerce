package com.ecommerce.controller;

import java.io.File;
import java.util.Date;
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

//import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsImage;
import com.ecommerce.entity.Users;
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

	@RequestMapping(value = "/imagen/producto/{id}", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile inputFile/* , @RequestBody ProductsImage prod */,@PathVariable Long id) {
//		Products pro = new Products();
		
		ProductsImage proima = new ProductsImage(), proImage = new ProductsImage();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
//	    File destinationFile = new File(context.getRealPath("/WEB-INF/images")+  File.separator + originalFilename);
				// ***************************************************************************************************
				// \\
				// C:\Users\Jorge.Diaz\Documents\GitHub\WebServiceEcommerce\ecommerce\src\main\webapp\WEB-INF\images
				// http://192.168.100.71:8090/ecommerce/
				// ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();
				// ***************************************************************************************************
				// \\
				File destinationFile = new File("C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"+ File.separator + originalFilename);
//	    File destinationFile = new File(ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(originalFilename).toUriString());
				inputFile.transferTo(destinationFile);
				proImage.setImageName(originalFilename);
				proima.setImageName(destinationFile.getPath());
//	    proImage.setFileSize(inputFile.getSize());
				headers.add("File Uploaded Successfully ", originalFilename);
				System.out.println("dato exitoso, address: " + destinationFile);
				System.out.println("file name: " + originalFilename);
				proImage.setIdImageProduct(null);// auto_increment				
				proImage.setImageCode(1);//numero quemado por el momento...
				proImage.setIdProduct(id);
				Object saveIma = genS.saveObject(proImage);
				proima.setIdImageProduct(proImage.getIdImageProduct());
				proima.setImageCode(1);
				proima.setIdProduct(id);
				System.out.println("OBJ:::::> " + saveIma);
				return new ResponseEntity<>(proima, headers, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Error Catcher: " + e);
				return new ResponseEntity<>("Error: Invalid file", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error: Empty file", HttpStatus.BAD_REQUEST);
		}
	}
// ********************************************************************************************************************* \\

	@RequestMapping(value="/imagen2", method = RequestMethod.POST, headers=("content-type=multipart/*"), produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> uploadWithServices( @RequestParam("file") MultipartFile inputFile) {
		
		ProductsImage proima = new ProductsImage(), proImage = new ProductsImage();//obj
		HttpHeaders headers = new HttpHeaders();//obj
		
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				File destinationFile = new File(
				"C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"+ File.separator + originalFilename
				);//
				inputFile.transferTo(destinationFile);
				proImage.setImageName(originalFilename);
				proima.setImageName(destinationFile.getPath());
				headers.add("File Uploaded Successfully ", originalFilename);//header to teh json response
				System.out.println("dato exitoso, destino: " + destinationFile);
				System.out.println("Nombre del archivo: " + originalFilename);
				proImage.setIdImageProduct(null);// auto_increment
				Object saveIma = genS.saveObject(proImage);//service
				System.out.println("OBJETO:::::> " + saveIma);
				return new ResponseEntity<>(proima, headers, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Error Catcher: " + e);
				return new ResponseEntity<>("Error: Invalid file", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error: Empty file", HttpStatus.BAD_REQUEST);
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
	
	
	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateUsers(@PathVariable("id") Long id, @RequestBody ProductsImage image) {
		
		if (image.getIdImageProduct() == id) {
			ProductsImage u = retrieveService.findByIdImage(id); //Retrieving the object with the id
			
			ProductsImage p = (ProductsImage) genS.updateObject(image); //Once Updated object 
			if (p != null && image.getIdImageProduct() != null) { 
				return new ResponseEntity<>(image, HttpStatus.OK); // return statement successful
			} else if ( p == null && image.getIdImageProduct() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if ( p == null && image.getIdImageProduct() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}

	// DELETE SINGLE ENTRY USERS
	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
		ProductsImage obj = new ProductsImage();
		obj.setIdImageProduct(id);

		String msj = genS.deleteObject(obj);

		if (msj.equalsIgnoreCase("ok")) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		}
		if (msj.equalsIgnoreCase("error")) {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		} else {
			return null;
		}
	}
	
}
