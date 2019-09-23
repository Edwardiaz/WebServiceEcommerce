package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.entity.ProductsImage;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IRetrieveImageService;
import com.ecommerce.service.ProductoService;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api")
@MultipartConfig
public class ImagesController {

	private IRetrieveImageService retrieveService;
	private ProductoService proService;
	private IGenericService genS;
	private CategoryService catService;

	@Autowired
	public ImagesController(IRetrieveImageService retrieveService, IGenericService genS, ProductoService proService, CategoryService catService) {
		this.retrieveService = retrieveService;
		this.genS = genS;
		this.proService = proService;
		this.catService = catService;
	}

	@Autowired
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
				
				// *************************************************************************************************** \\
				// C:\Users\Jorge.Diaz\Documents\GitHub\WebServiceEcommerce\ecommerce\src\main\webapp\WEB-INF\images
				// http://192.168.100.71:8090/ecommerce/
				// ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();
				// *************************************************************************************************** \\
				
				File destinationFile = new File("C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"+ File.separator + originalFilename);
//	   			File destinationFile = new File(ServletUriComponentsBuilder.fromCurrentContextPath().path("/").path(originalFilename).toUriString());
				inputFile.transferTo(destinationFile);
				proImage.setImageName(originalFilename);
				proima.setImageName(destinationFile.getPath());
//	    		proImage.setFileSize(inputFile.getSize());
				headers.add("File Uploaded Successfully ", originalFilename);
				System.out.println("dato exitoso, address: " + destinationFile);
				System.out.println("file name: " + originalFilename);
				proImage.setIdImageProduct(null);// auto_increment
				proImage.setImageCode(1);// numero quemado por el momento...
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
				proImage.setIdImageProduct(null);// auto_increment
				proImage.setImageCode(1);// numero quemado por el momento...
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
	//metodo crear producto, imagenes(muchass) y categoria
	@RequestMapping(value = "/producto/categoria/{id}/imagenes", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> uploadManyFiles(@RequestPart("files") List<MultipartFile> files, @RequestPart("data") Products pro, @PathVariable("id")Long id, HttpServletRequest servletRequest){
		HttpHeaders headers = new HttpHeaders();
		ProductsImage img = new ProductsImage(), proima = new ProductsImage();//you should add img to the loop... later
//		Products pro = new Products();
//		files.forEach(file -> img.setImageName(file.getOriginalFilename()));
//		files.forEach(file -> genS.saveObject(img));
		
        List<String> fileNames = new ArrayList<String>();
        
        if (pro.getIdProducts() == null || pro.getIdProducts() == 0) {
        	ProductsCategory procat = new ProductsCategory();
			pro.setProductDeliveryDate(new Date());
			pro.setUpdateDate(null);
			proService.saveProducts(pro);
			procat.setIdCategory(id);
			procat.setIdProducts(pro.getIdProducts());
			catService.saveProductsCategory(procat);
			System.out.println("DATA SAVED SUCCESSFULLY..."+procat.getIdProductsCategory());
		} else {
			System.out.println("PRO IS EMPTY, SO DO IMAGE...>" + pro);
		}
        
        if (null != files && files.size() > 0) {
        	
            for (MultipartFile multipartFile : files) {
            	
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                File imageFile = new File(servletRequest.getServletContext().getRealPath("/"), fileName);
                
                try {
                	System.out.println("RUTA DE GUARDADO::::>"+imageFile);
                	img.setImageName(fileName);
                	img.setImageCode(2);
                	img.setIdProduct(pro.getIdProducts());
                	genS.saveObject(img);
                	
                    multipartFile.transferTo(imageFile);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            
		headers.add("Number of files Uploaded successfully: ", String.valueOf(files.size()));
		return new ResponseEntity<>("Files and data saved succesfully", headers, HttpStatus.OK);
        }else {
        	headers.add("No files were detected: ", "Please select at least one file");
    		return new ResponseEntity<>("Data successfully saved, but no files were detected, you can update the register with images later...", headers, HttpStatus.OK);
        }
	}
	
	//METODO PARA CARGAR MUCHAS MUCHAS IMAGENES A UN PRODUCTO EXISTENTE
	@RequestMapping(value = "/producto/imagenes/{id}", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> uploadManyFileToPro(@RequestPart("files") List<MultipartFile> files, @PathVariable("id")Long id, HttpServletRequest servletRequest) {
		HttpHeaders headers = new HttpHeaders();
		ProductsImage img = new ProductsImage(), proima = new ProductsImage();//you should add img to the loop... later
		
        List<String> fileNames = new ArrayList<String>();
        
        if (null != files && files.size() > 0) {
        	
            for (MultipartFile multipartFile : files) {
            	
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                File imageFile = new File(servletRequest.getServletContext().getRealPath("/"), fileName);
                
                try {
                	System.out.println("RUTA DE GUARDADO::::>"+imageFile);
                	img.setImageName(fileName);
                	img.setImageCode(3);
                	img.setIdProduct(id);
                	genS.saveObject(img);
                	
                    multipartFile.transferTo(imageFile);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            
		headers.add("Number of files Uploaded successfully ", String.valueOf(files.size()));
		return new ResponseEntity<>("Files saved succesfully to the selected product...", headers, HttpStatus.OK);
        }else {
        	headers.add("No files were detected: ", "Please select at least one file");
    		return new ResponseEntity<>("No files were detected, please select at least one file and the product you want...", headers, HttpStatus.OK);
        }
	}
//************************************************************
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/imagen", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ProductsImage> findAllProImage() {
		List<ProductsImage> listProIma = retrieveService.findAllProImage();
		return listProIma;
	}

	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> imageById(@PathVariable("id") Long id) {
		ProductsImage ima = retrieveService.findByIdImage(id);
		if (ima != null) {
			return new ResponseEntity<>(ima, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestBody ProductsImage image) {

		if (image.getIdImageProduct() == id) {
			ProductsImage ima = retrieveService.findByIdImage(id); // Retrieving the object with the id
			ima.setImageName(ima.getImageName());
			ProductsImage p = (ProductsImage) genS.updateObject(image); // Once Updated object
			
			
			
			if (p != null && image.getIdImageProduct() != null) {
				return new ResponseEntity<>(image, HttpStatus.OK); // return statement successful
			} else if (p == null && image.getIdImageProduct() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (p == null && image.getIdImageProduct() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// DELETE single image
	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
		ProductsImage ima = retrieveService.findByIdImage(id);
		String originalFilename = (ima.getImageName());
		String msj = genS.deleteObject(ima);
		System.out.println("FILE NAME:::::> "+originalFilename);
		File destinationFile = new File(
				"C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"
						+ File.separator + originalFilename);
		if (destinationFile.delete()) {
			System.out.println("FILE DELETED SUCCESSFULLY");
		} else {
			System.out.println("Error deleting file, register is deleted anyways...");
		}
		if (msj.equalsIgnoreCase("ok")) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		}

		if (msj.equalsIgnoreCase("error")) {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		} else {
			System.out.println("RETURN NULL");
			return null;
		}
	}

}