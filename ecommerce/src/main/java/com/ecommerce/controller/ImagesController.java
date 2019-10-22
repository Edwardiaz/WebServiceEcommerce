package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.entity.ProductsImage;
import com.ecommerce.exception.StorageFileNotFoundException;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IRetrieveImageService;
import com.ecommerce.service.IntStorageService;
import com.ecommerce.service.ProductoService;

//import hello.FileUploadController;
//import hello.storage.StorageFileNotFoundException;
//import hello.storage.StorageService;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

@CrossOrigin
@RestController
@RequestMapping("/api")
@MultipartConfig
public class ImagesController {

	private IRetrieveImageService retrieveService;
	private ProductoService proService;
	private IGenericService genS;
	private CategoryService catService;
	private final IntStorageService storageService;

	@Autowired
	public ImagesController(IRetrieveImageService retrieveService, IGenericService genS, ProductoService proService,
							CategoryService catService, IntStorageService storageService) {
		this.retrieveService = retrieveService;
		this.genS = genS;
		this.proService = proService;
		this.catService = catService;
		this.storageService = storageService;
	}
	
	@RequestMapping(value = "/up", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
//		logger.info("inputStream: " + inputStream);
//		logger.info("originalName: " + originalName);
//		logger.info("name: " + name);
//		logger.info("contentType: " + contentType);
//		logger.info("size: " + size);
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(originalName, HttpStatus.OK);
	}
	
	
	    
	    //metodo para consultar las imagenes guardadas
//		@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
//	    @ResponseBody
//	    public ResponseEntity<?> listUploadedFiles(/*Model model*/) throws IOException {
//
///*model.addAttribute("files", */List<?> list = storageService.loadAll().map(path -> MvcUriComponentsBuilder
//						.fromMethodName(ImagesController.class,
//	                        "serveFile", path.getFileName().toString()).build().toString())
//	                .collect(Collectors.toList());
//
//	        return new ResponseEntity<>(list, HttpStatus.OK);
//	    }
	    
	    
	//carga el recurso si ex9iste para mandarla al navegador y descargarlo...
	    @GetMapping("/files/{filename:.+}")
	    @ResponseBody
	    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

	        Resource file = storageService.loadAsResource(filename);
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	    }

	    
	    //
	    @RequestMapping(value = "/store", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file,
	            RedirectAttributes redirectAttributes) {

	        storageService.store(file);
	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded " + file.getOriginalFilename() + "!");

	        return new ResponseEntity<>("file UPLOADED "+file.getOriginalFilename(), HttpStatus.OK);
	    }
	    
	    //EXCEPTION CUSTOM
	    @ExceptionHandler(StorageFileNotFoundException.class)
	    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
	        return ResponseEntity.notFound().build();
	    }
	
	
	/*@Autowired
	ServletContext context;

	// METODO GUARDAR IMAGENES A UN PRODUCTO EXISTENTE
	@RequestMapping(value = "/producto/image/{id}", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile inputFile, @PathVariable("id") Long id) {
		ProductsImage proima = new ProductsImage(), proImage = new ProductsImage();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				
//	    		File destinationFile = new File(context.getRealPath("/")+  File.separator + originalFilename);
				File destinationFile = new File("C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"+ File.separator + originalFilename);
//	   			File destinationFile = new File(ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(originalFilename).toUriString());
				inputFile.transferTo(destinationFile);
				proImage.setImageName(originalFilename);
				proima.setImageName(destinationFile.getPath());
//	    		proImage.setFileSize(inputFile.getSize());
				headers.add("File Uploaded Successfully ", originalFilename);
				System.out.println("dato exitoso, address: " + destinationFile);
				System.out.println("file name: " + originalFilename);
				proImage.setIdImageProduct(null);
				proImage.setImageCode(1);
				proImage.setIdProduct(id);
				Object saveIma = genS.saveObject(proImage);
				proima.setIdImageProduct(proImage.getIdImageProduct());
				proima.setImageCode(1);
				proima.setIdProduct(id);
				System.out.println("OBJ:::::> " + saveIma);
				return new ResponseEntity<>(proima, headers, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Error Catcher: " + e);
				return new ResponseEntity<>("Error: Invalid file or ad URL", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error: Empty file", HttpStatus.BAD_REQUEST);
		}
	}

// ********************************************************************************************************************* \\
	
//, MediaType.IMAGE_PNG_VALUE
	// saves image and creates new product
	@RequestMapping(value = "/producto/imagen", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = {MediaType.APPLICATION_JSON_VALUE }, consumes = { "multipart/form-data" })
	@ResponseBody
	public ResponseEntity<?> uploadProImage(@RequestPart("file") MultipartFile inputFile, @RequestPart("data") Products pro) {
		ProductsImage proima = new ProductsImage(), proImage = new ProductsImage();
		HttpHeaders headers = new HttpHeaders();
		System.out.println("INTO THE METHOD:::>File " + inputFile.getOriginalFilename());
		System.out.println("PRODUCT'S NAME::::> " + pro.getNameProducts());
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				File destinationFile = new File(
	"C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"+File.separator + originalFilename);
				inputFile.transferTo(destinationFile);
				proImage.setImageName(originalFilename);
				proima.setImageName(destinationFile.getPath());
				headers.add("File Uploaded Successfully ", originalFilename);
				System.out.println("success data, address: " + destinationFile);
				System.out.println("file name: " + originalFilename);

				// ******************* \\
				if (pro.getIdProducts() == null || pro.getIdProducts() == 0) {
					pro.setProductDeliveryDate(new Date());
					pro.setUpdateDate(null);
					proService.saveProducts(pro);
				} else {
					System.out.println("PRO IS EMPTY, SO DO IMAGE...>" + pro);
				}
				// ******************* \\
				proImage.setIdImageProduct(null);
				proImage.setImageCode(1);
				proImage.setIdProduct(pro.getIdProducts());
				Object saveIma = genS.saveObject(proImage);
				proima.setIdImageProduct(proImage.getIdImageProduct());
				proima.setImageCode(2);
				proima.setIdProduct(pro.getIdProducts());
				System.out.println("OBJ:::::> " + saveIma);
				return new ResponseEntity<>(proima, headers, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Error Catcher: " + e);
				return new ResponseEntity<>("Error: Invalid file or invalid fields", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error: Empty file or url not found", HttpStatus.BAD_REQUEST);
		}
	}
//********************************************************************
*/
}