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

import com.ecommerce.entity.Category;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryProCatRestController {

	private CategoryService catService;

	@Autowired
	public CategoryProCatRestController(CategoryService catService) {
		this.catService = catService;
	}
	
	// metodo insertar
	@RequestMapping(value = "/categoria", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveCategory(@RequestBody Category cat) {
				
		if(cat.getIdCategory() == null || cat.getIdCategory() == 0 || cat.getIdCategoryPadre()== null || cat.getIdCategoryPadre()==0) {
			return new ResponseEntity<>(catService.saveCategory(cat), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(cat, HttpStatus.BAD_REQUEST);
		}
	}

	// metodo consultar
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/categoria", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Category> getCategoria() {
		
		List<Category> list = catService.findAllCategory();
		return list;
		
	}

	// metodo find by id
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
		Category cat = catService.findByIdCategory(id);
		if(cat != null) {
			return new ResponseEntity<>(catService.findByIdCategory(id), HttpStatus.FOUND);
		}else{
	        return new ResponseEntity<>(catService.findByIdCategory(id), HttpStatus.NOT_FOUND);
	    } 
		
	}
 
	// metodo delete
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {	
		String pro = catService.deleteCategory(id);
		
		if (pro.equalsIgnoreCase("ok")) {
			return new ResponseEntity<>(pro, HttpStatus.OK);
		} if(pro.equalsIgnoreCase("error")) {
			return new ResponseEntity<>(pro, HttpStatus.NO_CONTENT);
		}
		else {
			return null;
		}
	}

	//metodo update
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category cat) {
		
		if(cat.getIdCategory() == id) {
			Category cate = catService.updateCategory(cat);
			if(cate != null && cat.getIdCategory() != null) {
				return new ResponseEntity<>(catService.updateCategory(cat), HttpStatus.OK); 
			}else if(cate == null && cat.getIdCategory() != null) {
				return new ResponseEntity<>("NO SE ENCUENTRA EL REGISTRO", HttpStatus.NOT_FOUND);
			}else if(cate == null && cat.getIdCategory() == null) {
				return new ResponseEntity<>("Algunos parametros son invalidos", HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<>("Parametros invalidos o mala sintaxis en la peticion", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("ID NO COINCIDEN", HttpStatus.BAD_REQUEST);
		}
	}
	
	///******************************************* \\
	
	//metodo save
	@RequestMapping(value = "/procat", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProCat(@RequestBody ProductsCategory cat) {
		
		if(cat.getIdProductsCategory() == null || cat.getIdProductsCategory() == 0) {
			return new ResponseEntity<>(catService.saveProductsCategory(cat), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(cat, HttpStatus.BAD_REQUEST);
		}
	}

	// metodo consultar
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/procat", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ProductsCategory> getProCat() {
		List<ProductsCategory> list = catService.findAllProductsCategory();
		return list;
	}

	// metodo find by id
	@RequestMapping(value = "/procat/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> getProCatById(@PathVariable("id") Long id) { 
		
		ProductsCategory proCat = catService.findByIdProductsCategory(id);
		
		if(proCat != null) {
			return new ResponseEntity<>(catService.findByIdProductsCategory(id), HttpStatus.FOUND);
		}else{
	        return new ResponseEntity<>(catService.findByIdProductsCategory(id), HttpStatus.NOT_FOUND);
	    }
	}
 
	// metodo delete
	@RequestMapping(value = "/procat/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteProCat(@PathVariable("id") Long id) {
		String proCat = catService.deleteProductsCategory(id);
		
		if (proCat.equalsIgnoreCase("ok")) {
			return new ResponseEntity<>(proCat, HttpStatus.OK);
		} if(proCat.equalsIgnoreCase("error")) {
			return new ResponseEntity<>(proCat, HttpStatus.NO_CONTENT);
		}
		else {
			return null;
		}
	}

	//metodo update
	@RequestMapping(value = "/procat/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateProCat(@PathVariable("id") Long id, @RequestBody ProductsCategory cat) {
		
		if(cat.getIdProductsCategory() == id) {
			ProductsCategory procat = catService.updateProductsCategory(cat);
			if(procat != null && cat.getIdProductsCategory() != null) {
				return new ResponseEntity<>(catService.updateProductsCategory(cat), HttpStatus.OK); 
			}else if(procat == null && cat.getIdProductsCategory() != null) {
				return new ResponseEntity<>("NO SE ENCUENTRA EL REGISTRO", HttpStatus.NOT_FOUND);
			}else if(procat == null && cat.getIdProductsCategory() == null) {
				return new ResponseEntity<>("Algunos parametros son invalidos", HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<>("Parametros invalidos o mala sintaxis en la peticion", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("ID NO COINCIDEN", HttpStatus.BAD_REQUEST);
		}
	}
}
