package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

//import com.ecommerce.entity.ProImageMirror;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.entity.ProductsImage;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IRelationService;
import com.ecommerce.service.IRetrieveImageService;
import com.ecommerce.service.ProductoService;

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

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> index() {
		return new ResponseEntity<>("E-commerce", HttpStatus.I_AM_A_TEAPOT);
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
			return new ResponseEntity<>("Error, Some Parameter are invalid or method not valid",HttpStatus.BAD_REQUEST);
		}
	}

	// METODO INSERTAR CON CATEGORIA
	@RequestMapping(value = "/producto/categoria/{id}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
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

			Products pr = proService.saveProducts(pro);
			procat.setIdProducts(pr.getIdProducts());
			catService.saveProductsCategory(procat);
			return new ResponseEntity<>(procat, HttpStatus.CREATED);
		} else {
			System.out.println("ERROR: BAD REQUEST");
			return new ResponseEntity<>("Some Parameter are invalid", HttpStatus.BAD_REQUEST);
		}
	}
	
	//NEW METHOD UPLOAD IMAGE...
	@RequestMapping(value = "/product/images/upload", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> imageUpload(@RequestParam("files") List<MultipartFile> file, @RequestParam("id") Long id){
		
		Map<String, Object> response = new HashMap<>();
		
		Products pro = proService.findByIdProducts(id);
		ProductsImage proImage = new ProductsImage();
		
		if(!file.isEmpty()) {
			for(MultipartFile files : file) {
			String fileName = UUID.randomUUID().toString() +"_"+ files.getOriginalFilename().replace(" ","");
			Path filePath = 
					Paths.get("C:\\Users\\Jorge.Díaz\\Documents\\GitHub\\WebServiceEcommerce\\ecommerce\\src\\main\\webapp\\images").resolve(fileName).toAbsolutePath();
//					
			System.out.println("RUta del archivo: "+filePath);
			try {
				System.out.println("dentro del try: "+files.getInputStream());
				Files.copy(files.getInputStream(), filePath);
			} catch (IOException e) {
				System.out.println("detnro del catch: "+response.toString());
				response.put("message", "There was a problem when uploading the file "+fileName);
//				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			proImage.setImageName(fileName);
			proImage.setIdProduct(id);
			proImage.setUrl("http://192.168.100.36:8090/ecommerce/images/"+fileName);
			genS.saveObject(proImage);
			response.put("Imagen", proImage);
			response.put("message", "Image uploaded sucessfuly");
			}
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// method create a product, images(a lot) & category/////
		@RequestMapping(value = "/product/category/{id}", method = RequestMethod.POST, produces = {	MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> uploadManyFiles(@RequestPart("files") List<MultipartFile> files,
				@RequestPart("data") Products pro, @PathVariable("id") Long id, HttpServletRequest servletRequest) {
			HttpHeaders headers = new HttpHeaders();
			ProductsImage img = new ProductsImage(), proima = new ProductsImage();
			// lambda for saving files... it works
//				Products pro = new Products();
//				files.forEach(file -> img.setImageName(file.getOriginalFilename()));
//				files.forEach(file -> genS.saveObject(img));
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
							"C:\\Users\\Jorge.Dï¿½az\\Documents\\GitHub\\WebServiceEcommerce\\ecommerce\\src\\main\\webapp\\images\\"+ fileName);
					try {
						System.out.println("RUTA DE GUARDADO ::::>" + imageFile);
						img.setImageName(fileName);
						img.setIdProduct(pro.getIdProducts());
						img.setUrl("http://192.168.100.36:8090/ecommerce/images/" + fileName);
						genS.saveObject(img);
						multipartFile.transferTo(imageFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				headers.add("Number of files Uploaded successfully: ", String.valueOf(files.size()));
				return new ResponseEntity<>(files, headers, HttpStatus.OK);
			} else {
				headers.add("No files were detected: ", "Please select at least one file");
				return new ResponseEntity<>("Data successfully saved, but no files were detected, you can update the register with images later...",
						headers, HttpStatus.OK);
			}
		}
	
	// UPDATE PRODUCT WITH CATEGORY//
	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateProductsAndCategory(@PathVariable Long id, @RequestBody Products pro) {
		System.out.println("**************** ID que viene del FRONT " + id);
		if (pro.getIdProducts() == id) {
			Products p = proService.findByIdProducts(id);
			ProductsCategory newCatPro = new ProductsCategory();
			for (ProductsCategory procat : p.getProductsCategorySet()) {
				System.out.println("pro.getListCat()::::::> " + pro.getListCat());
				if (procat.getIdProducts() == id) {

					catService.deleteProductsCategory(procat.getIdProductsCategory());
				}

				if (p != null) {
					pro.setProductDeliveryDate(p.getProductDeliveryDate());
					pro.setUpdateDate(new Date());
					newCatPro.setIdProducts(id);
					newCatPro.setIdCategory(pro.getListCat());
				} else {
					pro.setProductDeliveryDate(null);
					pro.setUpdateDate(new Date());
					newCatPro.setIdProducts(id);
					newCatPro.setIdCategory(pro.getListCat());
				}
				Products prod = proService.updateProducts(pro);
				ProductsCategory catPro = catService.saveProductsCategory(newCatPro);
				if (prod != null && pro.getIdProducts() != null) {
//				pro.setUpdateDate(new Date());
					// proService.updateProducts(pro)
					return new ResponseEntity<>(prod, HttpStatus.OK);
				} else if (prod == null && pro.getIdProducts() != null) {
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
				} else if (prod == null && pro.getIdProducts() == null) {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				} else {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("FATAL ERROR code 204", HttpStatus.NO_CONTENT);
	}

	// RETRIEVE METHOD//
//	@CrossOrigin(origins = "http://localhost:3000/catalogo")
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/product", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Products> getProducts(HttpServletRequest request) {

		List<Products> list = proService.findAll();
		for (Products pro : list) {

			for (ProductsImage proima : pro.getProImageSet()) {
				if (pro.getIdProducts() == proima.getIdProduct() && pro.getProImageSet() != null) {
					String fileName = proima.getImageName();

					proima.setUrl("http://192.168.100.36:8090/ecommerce/images/" + fileName);

					genS.updateObject(proima);

					System.out.println("URL IMAGEN: " + proima.getUrl() + " CON ID: " + pro.getIdProducts());
					System.out.println("LISTA IMAGEN: " + pro.getProImageSet());
				}
			}
		}
		System.out.println("IP CONSULTANTE: " + request.getRemoteAddr());
		return list;
	}

	// FIND BY ID METHOD//
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id, HttpServletRequest request) {

		Products pro = proService.findByIdProducts(id);

		if (pro != null) {
			for (ProductsImage proima : pro.getProImageSet()) {
				if (id == proima.getIdProduct()) {
					String fileName = proima.getImageName();
					proima.setUrl("http://192.168.100.36:8090/ecommerce/images/" + fileName);

					genS.updateObject(proima);

					System.out.println("URL IMAGEN: " + proima.getUrl() + " CON ID: " + pro.getIdProducts());
					System.out.println("LISTA IMAGEN: " + pro.getProImageSet());
				}
			}
			return new ResponseEntity<>(pro, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("ERROR: No register found...", HttpStatus.NOT_FOUND);
		}
	}

	// DELETE METHOD//
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteProducts(@PathVariable("id") Long id) {

		Products prod = new Products();
//		prod.setIdProductducts(id); 
		boolean pro = proService.deletePro(id);
//		boolean pro = genS.deleteObject(prod, id);
		if (pro) {
			return new ResponseEntity<>(pro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}	

	// METODO PARA CARGAR MUCHAS MUCHAS IMAGENES A UN PRODUCTO EXISTENTE
	@RequestMapping(value = "/images/product/{id}", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> uploadManyFileToPro(@RequestPart("files") List<MultipartFile> files,
			@PathVariable("id") Long id, HttpServletRequest servletRequest) {
		HttpHeaders headers = new HttpHeaders();
		ProductsImage img = new ProductsImage();// ***

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {

			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				File imageFile = new File(
						"C:\\Users\\Jorge.Dï¿½az\\Documents\\GitHub\\WebServiceEcommerce\\ecommerce\\src\\main\\webapp\\images\\"+ fileName);
				try {
					System.out.println("RUTA DE GUARDADO::::>" + imageFile);
					img.setImageName(fileName);
					img.setImageCode(3);
					img.setIdProduct(id);
					img.setUrl("http://192.168.100.36:8090/ecommerce/images/" + fileName);
					genS.saveObject(img);
					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			headers.add("Number of files Uploaded successfully ", String.valueOf(files.size()));
			return new ResponseEntity<>(img, headers, HttpStatus.OK);
		} else if (files.isEmpty() == true || files.size() == 0) {
			System.out.println("ENTRO AL METODO CON :::::> " + files.size());
			return new ResponseEntity<>("empty file", headers, HttpStatus.OK);
		} else {
			headers.add("No files were detected: ", "Please select at least one file");
			return new ResponseEntity<>(
					"No files were detected, please select at least one file and the product you want...", headers,
					HttpStatus.OK);
		}
	}

	// filter images for specific id prod...
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/image/product/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> findByidProducts(@PathVariable("id") Long id) {

		List<ProductsImage> list = relS.findByidProducts(id);
		if (list.size() > 0) {
			for (ProductsImage proima : list) {
				String fileName = proima.getImageName();
				proima.setUrl("http://192.168.100.36:8090/ecommerce/images/" + fileName);
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

	// filter products for specific id cat...
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/products/category/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> findByidCategory(@PathVariable("id") Long id) {
		List<ProductsCategory> list = relS.findByidCategory(id);
		if (list.size() > 0) {
			System.out.println("LISTAAA " + list);
			return new ResponseEntity<>(list, HttpStatus.FOUND);
		} else if (list.size() == 0) {
			logger.error("Register doesn't have products or doesn't exist, ID: " + id);
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
	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.DELETE, produces = {	MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
		ProductsImage ima = retrieveService.findByIdImage(id);
		String originalFilename = (ima.getImageName());
		boolean boo = genS.deleteObject(ima, null);
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
