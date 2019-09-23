package com.ecommerce.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductoService proService;
	private CategoryService catService;
	
	@Autowired
	public ProductRestController(ProductoService proService, CategoryService catService) {
		this.proService = proService;
		this.catService = catService;
	}
	
	@RequestMapping("")
	@ResponseBody
	public String index() {
		return "E-commerce";
	}
	
	//CRUD

	// metodo insertar
	@RequestMapping(value = "/producto", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProducts(@RequestBody Products pro) {
		if(pro.getIdProducts() == null || pro.getIdProducts() == 0) {
			pro.setProductDeliveryDate(new Date());
			pro.setUpdateDate(null);
		return new ResponseEntity<>(proService.saveProducts(pro), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Error, Some Parameter are invalid or method not valid", HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo insertar con categoria
	@RequestMapping(value = "/producto/categoria/{id}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProductsCate(@RequestBody Products pro, @PathVariable("id")Long id) {
		System.out.println("ENTRO AL METODO saveProductsCate");
		if(pro.getIdProducts() == null || pro.getIdProducts() == 0) {
			ProductsCategory procat = new ProductsCategory();
			pro.setProductDeliveryDate(new Date());
			pro.setUpdateDate(null);
			procat.setIdCategory(id);
			
			System.out.println("ID DE LA URI:::::> "+id);
			System.out.println("ID CATEGORIA:::::> "+procat.getIdCategory());
			
			Products pr = proService.saveProductsCate(pro);
			procat.setIdProducts(pr.getIdProducts());
			catService.saveProductsCategory(procat);
		return new ResponseEntity<>(procat, HttpStatus.CREATED);
		}else {
			System.out.println("ERROR: BAD REQUEST");
			return new ResponseEntity<>("Some Parameter are invalid", HttpStatus.BAD_REQUEST);
		}
	}
	
	//create a product with category and image
//	@RequestMapping(value = "/producto/category/{id}/imagen", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> saveProImage(@RequestBody Products pro, @PathVariable("id")Long id, @RequestParam("file") MultipartFile inputFile) {
//		
//		System.out.println("ENTRO AL METODO saveProdImage");
//		HttpHeaders headers = new HttpHeaders();
//		if(pro.getIdProducts() == null || pro.getIdProducts() == 0) {
//			
//			ProductsCategory procat = new ProductsCategory();
//			
//			pro.setProductDeliveryDate(new Date());
//			pro.setUpdateDate(null);
//			procat.setIdCategory(id);
//			
//			System.out.println("ID DE LA URI:::::> "+id);
//			System.out.println("ID CATEGORIA:::::> "+procat.getIdCategory());
//			
//			Products pr = proService.saveProductsCate(pro);
//			procat.setIdProducts(pr.getIdProducts());
//			catService.saveProductsCategory(procat);
//			headers.add("Data registered Successfully ", "Products-Category");
//		return new ResponseEntity<>(pro, headers, HttpStatus.CREATED);
//		}else {
//			System.out.println("ERROR: BAD REQUEST");
//			return new ResponseEntity<>("Some Parameter are invalid", HttpStatus.BAD_REQUEST);
//		}
//	}

	// metodo consultar
	@ResponseStatus(code = HttpStatus.FOUND)//Debo crear una funcion para llamar este httpStatus
	@RequestMapping(value = "/producto", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Products> getProducts() {
		List<Products> list = proService.findAll();
			return list;
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
	}

	// metodo update
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateProducts(@PathVariable Long id, @RequestBody Products pro) {
		
		if(pro.getIdProducts() == id) {
			Products p = proService.findByIdProducts(id);
			if(p != null) {
				pro.setProductDeliveryDate(pro.getProductDeliveryDate());
			}else {
				pro.setProductDeliveryDate(null);
			}
			Products prod = proService.updateProducts(pro);
			
			if(prod != null && pro.getIdProducts() != null) {
				pro.setUpdateDate(new Date());
				// proService.updateProducts(pro)
				return new ResponseEntity<>("Register Updated Succesfully", HttpStatus.OK); 
			}else if(prod == null && pro.getIdProducts() != null) {
				return new ResponseEntity<>("REGISTER NOT FOUND", HttpStatus.NOT_FOUND);
			}else if(prod == null && pro.getIdProducts() == null) {
				return new ResponseEntity<>("Some parameters are invalid", HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<>("Some parameters are invalid or bad syntax in the request", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("ID mismatch", HttpStatus.BAD_REQUEST);
		}
	}
	

	/// ******************************************* \\\
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/vector", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Integer[] array() {
		Integer [] ex = new Integer[5];
		ex[0] = 6;
		ex[1] = 6;
		ex[2] = 6;
		ex[3] = 6;
		ex[4] = 6;
			return ex;
	}
	
//	@ResponseStatus(code = HttpStatus.OK)
//	@RequestMapping(value = "/vector/{exp}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public Integer[] arrayPrint1(@PathVariable("exp") Integer[] expe) {
//		System.out.println("LO QUE ENTRA ES ESTO:::::>"+expe);
//		for (int i = 0; i < expe.length; i++) {
//			System.out.println("VALORES DEL VECTOR "+expe[i]);
//		}
//	
//			return expe;
//	}
	
	// ESTRUTURA POST DEL ARRAY DE ID's
    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/vector/{exp}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Integer[] arrayPrint2(@PathVariable("exp") Integer expe){
    	System.out.println("DENTRO DEL METODO");
    	Integer[] exp = new Integer[expe];
        for (int i = 0; i < expe; i++) {
            System.out.println("VALORES DEL VECTOR "+exp[i]);
        }
            return exp;
    }
}
