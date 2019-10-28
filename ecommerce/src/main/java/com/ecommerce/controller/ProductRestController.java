package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ecommerce.service.IRelationService;
import com.ecommerce.service.IRetrieveImageService;
import com.ecommerce.service.ProductoService;
import com.ecommerce.service.ServiceById;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductRestController {

	private Logger logger = LogManager.getLogger(ProductRestController.class);
	private IRetrieveImageService retrieveService;
	private ProductoService proService;
	private IGenericService genS;
	private CategoryService catService;
	private IRelationService relS;
	private IRetrieveImageService imageService;

	@Autowired
	public ProductRestController(ProductoService proService, CategoryService catService,
			IRetrieveImageService retrieveService, IGenericService genS, IRelationService relS,
			IRetrieveImageService imageService) {
		this.proService = proService;
		this.catService = catService;
		this.retrieveService = retrieveService;
		this.genS = genS;
		this.relS = relS;
		this.imageService = imageService;
	}

	@RequestMapping("")
	@ResponseBody
	public String index() {
		return "E-commerce";
	}

	// CRUD

	// metodo insertar
	@RequestMapping(value = "/pro", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProducts(@RequestBody Products pro) {
		if (pro.getIdProducts() == null || pro.getIdProducts() == 0) {
			pro.setProductDeliveryDate(new Date());
			pro.setUpdateDate(null);
			return new ResponseEntity<>(proService.saveProducts(pro), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error, Some Parameter are invalid or method not valid",
					HttpStatus.BAD_REQUEST);
		}
	}

	// metodo insertar con categoria
	@RequestMapping(value = "/product/category/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProductsCate(@RequestBody Products pro, @PathVariable("id") Long id) {
		System.out.println("ENTRO AL METODO saveProductsCate");
		if (pro.getIdProducts() == null || pro.getIdProducts() == 0) {
			ProductsCategory procat = new ProductsCategory();
			pro.setProductDeliveryDate(new Date());
			pro.setUpdateDate(null);
			procat.setIdCategory(id);

			logger.error("ID DE LA URI:::::> " + id);
			System.out.println("ID CATEGORIA:::::> " + procat.getIdCategory());

			Products pr = proService.saveProductsCate(pro);
			procat.setIdProducts(pr.getIdProducts());
			catService.saveProductsCategory(procat);
			return new ResponseEntity<>(procat, HttpStatus.CREATED);
		} else {
			System.out.println("ERROR: BAD REQUEST");
			return new ResponseEntity<>("Some Parameter are invalid", HttpStatus.BAD_REQUEST);
		}
	}

	// retrieve method
//	@CrossOrigin(origins = "http://localhost:3000/catalogo")
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/producto", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Products> getProducts(HttpServletRequest request) {

		List<Products> list = proService.findAll();

		for (Products pro : list) {

			for (ProductsImage proima : pro.getProImageSet()) {
				if (pro.getIdProducts() == proima.getIdProduct() && pro.getProImageSet() != null) {
					String fileName = proima.getImageName();

//					proima.setUrl("http://192.168.100.72:8090/ecommerce/images/" + fileName);
					proima.setUrl("http://192.168.1.12:8080/ecommerce/images/" + fileName);

					genS.updateObject(proima);

					System.out.println("URL IMAGEN: " + proima.getUrl() + " CON ID: " + pro.getIdProducts());
					System.out.println("LISTA IMAGEN: " + pro.getProImageSet());
				}
			}
		}
		System.out.println("IP CONSULTANTE: " + request.getRemoteAddr());
		return list;
	}

	// find by id method
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {

		Products pro = proService.findByIdProducts(id);

		if (pro != null) {
			for (ProductsImage proima : pro.getProImageSet()) {
				if (id == proima.getIdProduct()) {
					String fileName = proima.getImageName();
//					proima.setUrl("http://192.168.100.72:8090/ecommerce/images/" + fileName);
					proima.setUrl("http://192.168.1.12:8080/ecommerce/images/" + fileName);

					genS.updateObject(proima);
					
					System.out.println("URL IMAGEN: " + proima.getUrl() + " CON ID: " + pro.getIdProducts());
					System.out.println("LISTA IMAGEN: " + pro.getProImageSet());
				}
			}
			return new ResponseEntity<>(pro,HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("ERROR: No register found...", HttpStatus.NOT_FOUND);
		}
	}

	// delete method
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteProducts(@PathVariable("id") Long id) {
		boolean pro = proService.deletePro(id);

		if (pro) {
			return new ResponseEntity<>(pro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again: "+pro,
					HttpStatus.NO_CONTENT);
		}
	}

	// update method
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateProducts(@PathVariable Long id, @RequestBody Products pro) {

		if (pro.getIdProducts() == id) {
			Products p = proService.findByIdProducts(id);
			if (p != null) {
				pro.setProductDeliveryDate(p.getProductDeliveryDate());
				pro.setUpdateDate(new Date());
			} else {
				pro.setProductDeliveryDate(null);
				pro.setUpdateDate(new Date());
			}
			Products prod = proService.updateProducts(pro);

			if (prod != null && pro.getIdProducts() != null) {
//				pro.setUpdateDate(new Date());
				// proService.updateProducts(pro)
				return new ResponseEntity<>("Register Updated Succesfully", HttpStatus.OK);
			} else if (prod == null && pro.getIdProducts() != null) {
				return new ResponseEntity<>("REGISTER NOT FOUND", HttpStatus.NOT_FOUND);
			} else if (prod == null && pro.getIdProducts() == null) {
				return new ResponseEntity<>("Some parameters are invalid", HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Some parameters are invalid or bad syntax in the request",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("ID mismatch", HttpStatus.BAD_REQUEST);
		}
	}

	// method create a product, images(a lot) & category
	@RequestMapping(value = "/producto/categoria/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> uploadManyFiles(@RequestPart("files") List<MultipartFile> files,
			@RequestPart("data") Products pro, @PathVariable("id") Long id, HttpServletRequest servletRequest) {
		HttpHeaders headers = new HttpHeaders();
		ProductsImage img = new ProductsImage(), proima = new ProductsImage();

		// lambda for saving files... it works
//			Products pro = new Products();
//			files.forEach(file -> img.setImageName(file.getOriginalFilename()));
//			files.forEach(file -> genS.saveObject(img));

		List<String> fileNames = new ArrayList<String>();
		if (pro.getIdProducts() == null || pro.getIdProducts() == 0) {
			ProductsCategory procat = new ProductsCategory();
			pro.setProductDeliveryDate(new Date());
			pro.setUpdateDate(null);
			proService.saveProducts(pro);
			procat.setIdCategory(id);
			procat.setIdProducts(pro.getIdProducts());
			catService.saveProductsCategory(procat);
			System.out.println("DATA SAVED SUCCESSFULLY..." + procat.getIdProductsCategory());
		} else {
			System.out.println("PRO IS EMPTY, SO DO IMAGE...>" + pro);
		}

		if (null != files && files.size() > 0) {

			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				File imageFile = new File(
						"C:\\Users\\Jorge.Díaz\\Documents\\GitHub\\WebServiceEcommerce\\ecommerce\\src\\main\\webapp\\images\\"
								+ fileName);

				try {
					System.out.println("RUTA DE GUARDADO::::>" + imageFile);
					img.setImageName(fileName);
					img.setIdProduct(pro.getIdProducts());
					genS.saveObject(img);

					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			headers.add("Number of files Uploaded successfully: ", String.valueOf(files.size()));
			return new ResponseEntity<>("Files and data saved succesfully", headers, HttpStatus.OK);
		} else {
			headers.add("No files were detected: ", "Please select at least one file");
			return new ResponseEntity<>(
					"Data successfully saved, but no files were detected, you can update the register with images later...",
					headers, HttpStatus.OK);
		}
	}

	// METODO PARA CARGAR MUCHAS MUCHAS IMAGENES A UN PRODUCTO EXISTENTE
	@RequestMapping(value = "/imagenes/producto/{id}", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> uploadManyFileToPro(@RequestPart("files") List<MultipartFile> files,
			@PathVariable("id") Long id, HttpServletRequest servletRequest) {
		HttpHeaders headers = new HttpHeaders();
		ProductsImage img = new ProductsImage(), proima = new ProductsImage();// ***

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {

			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				File imageFile = new File(
						"C:\\Users\\Jorge.Díaz\\Documents\\GitHub\\WebServiceEcommerce\\ecommerce\\src\\main\\webapp\\images\\"
								+ fileName);

				try {
					System.out.println("RUTA DE GUARDADO::::>" + imageFile);
					img.setImageName(fileName);
					img.setImageCode(3);
					img.setIdProduct(id);
					genS.saveObject(img);

					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			headers.add("Number of files Uploaded successfully ", String.valueOf(files.size()));
			return new ResponseEntity<>("Files saved succesfully to the selected product...", headers, HttpStatus.OK);
		} else {
			headers.add("No files were detected: ", "Please select at least one file");
			return new ResponseEntity<>(
					"No files were detected, please select at least one file and the product you want...", headers,
					HttpStatus.OK);
		}
	}

	// filter images for specific id prod...
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/imagen/producto/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> findByidProducts(@PathVariable("id") Long id) {

		List<ProductsImage> list = relS.findByidProducts(id);
		if (list.size() > 0) {
			for (ProductsImage proima : list) {
				String fileName = proima.getImageName();
//				proima.setUrl("http://192.168.100.72:8090/ecommerce/images/" + fileName);
				proima.setUrl("http://192.168.1.12:8080/ecommerce/images/" + fileName);

				genS.updateObject(proima);
			}

			System.out.println("LISTAAA " + list);
			return new ResponseEntity<>(list, HttpStatus.FOUND);
		} else if (list.size() == 0) {
			logger.error("Register doesn't have images or doesn't exist, ID: " + id);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error: register doesn't exist...", HttpStatus.NO_CONTENT);
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
		boolean boo = genS.deleteObject(ima);
//			System.out.println("FILE NAME:::::> "+originalFilename);
		File destinationFile = new File(
				"C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/webapp/WEB-INF/images"
						+ File.separator + originalFilename);
		if (destinationFile.delete()) {
//				System.out.println("FILE DELETED SUCCESSFULLY");
		} else {
			logger.error("Error deleting file, register is deleted anyways...");
		}
		if (boo) {
			return new ResponseEntity<>("Register deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error deleting register", HttpStatus.NO_CONTENT);
		}
	}
}
