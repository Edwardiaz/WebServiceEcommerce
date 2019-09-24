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

import com.ecommerce.entity.ConfigProducts;
import com.ecommerce.entity.ConfigPromotions;
import com.ecommerce.entity.ProductsConfigProducts;
import com.ecommerce.entity.TypeAttribute;
import com.ecommerce.service.IAllListService;
import com.ecommerce.service.IByIdService;
import com.ecommerce.service.IGenericService;

@RestController
@RequestMapping(value = "/api")
public class ConfigPromoController {

	private IGenericService genS;
	private IAllListService listS;
	private IByIdService byIdS;

	// DEPENDENCY INJECTIONS
	@Autowired
	public ConfigPromoController(IGenericService genS, IAllListService listS, IByIdService byIdS) {
		this.genS = genS;
		this.listS = listS;
		this.byIdS = byIdS;
	}

	// Here we have TypeAttribute, ConfigProducts, ConfigPromotions,
	// ProductsConfigProducts
	// *************************************************TypeAttribute*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/typeAttribute", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<TypeAttribute> findAllSettingsShop() {
		return listS.allTypeAttribute();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/typeAttribute/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> typeAttributeById(@PathVariable("id") Long id) {
		TypeAttribute obj = byIdS.getTypeAttributeById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/typeAttribute/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteSettingsShop(@PathVariable("id") Long id) {
		TypeAttribute obj = new TypeAttribute();
		obj.setIdTypeAttribute(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/typeAttribute", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveTypeAttribute(@RequestBody TypeAttribute obj) {
		if (obj.getIdTypeAttribute() == null || obj.getIdTypeAttribute() == 0) {
			obj.setDate(new Date()); // Setting date from the system

			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/typeAttribute/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateTypeAttribute(@PathVariable("id") Long id, @RequestBody TypeAttribute obj) {
		if (obj.getIdTypeAttribute() == id) {

			obj.setDate(new Date()); // Setting date from the system
			TypeAttribute ret = (TypeAttribute) genS.updateObject(obj);

			if (ret != null && obj.getIdTypeAttribute() != null) {
				System.out.println("*******We did't know if attribute date has to be updated every time ");
				System.out.println("*******So it gets updated anyways ");
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdTypeAttribute() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdTypeAttribute() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************ConfigProducts*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/configProducts", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ConfigProducts> findAllConfigProducts() {
		return listS.allConfigProducts();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/configProducts/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> configProductsById(@PathVariable("id") Long id) {
		ConfigProducts obj = byIdS.getConfigProductsById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/configProducts/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteConfigProducts(@PathVariable("id") Long id) {
		ConfigProducts obj = new ConfigProducts();
		obj.setIdConfigProducts(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/configProducts", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveConfigProducts(@RequestBody ConfigProducts obj) {
		if (obj.getIdConfigProducts() == null || obj.getIdConfigProducts() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/configProducts/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateConfigProducts(@PathVariable("id") Long id, @RequestBody ConfigProducts obj) {
		if (obj.getIdConfigProducts() == id) {

			ConfigProducts ret = (ConfigProducts) genS.updateObject(obj);

			if (ret != null && obj.getIdConfigProducts() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdConfigProducts() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdConfigProducts() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************ConfigPromotions*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/configPromotions", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ConfigPromotions> findConfigPromotions() {
		return listS.allConfigPromotions();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/configPromotions/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> configPromotionsById(@PathVariable("id") Long id) {
		ConfigPromotions obj = byIdS.getConfigPromotionsById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/configPromotions/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteConfigPromotions(@PathVariable("id") Long id) {
		ConfigPromotions obj = new ConfigPromotions();
		obj.setIdConfigPromotions(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/configPromotions", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveSettingsShop(@RequestBody ConfigPromotions obj) {
		if (obj.getIdConfigPromotions() == null || obj.getIdConfigPromotions() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/configPromotions/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateConfigPromotions(@PathVariable("id") Long id, @RequestBody ConfigPromotions obj) {
		if (obj.getIdConfigPromotions() == id) {
			ConfigPromotions ret = (ConfigPromotions) genS.updateObject(obj);
			if (ret != null && obj.getIdConfigPromotions() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdConfigPromotions() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdConfigPromotions() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************ProductsConfigProducts*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/productsConfigProducts", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ProductsConfigProducts> findAllProductsConfigProducts() {
		return listS.allProductsConfigProducts();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/productsConfigProducts/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> productsConfigProductsById(@PathVariable("id") Long id) {
		ProductsConfigProducts obj = byIdS.getProductsConfigProductsById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/productsConfigProducts/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteProductsConfigProducts(@PathVariable("id") Long id) {
		ProductsConfigProducts obj = new ProductsConfigProducts();
		obj.setIdProductsConfigProducts(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/productsConfigProducts", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveProductsConfigProducts(@RequestBody ProductsConfigProducts obj) {
		if (obj.getIdProductsConfigProducts() == null || obj.getIdProductsConfigProducts() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/productsConfigProducts/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateProductsConfigProducts(@PathVariable("id") Long id,
			@RequestBody ProductsConfigProducts obj) {
		if (obj.getIdProductsConfigProducts() == id) {
			ProductsConfigProducts ret = (ProductsConfigProducts) genS.updateObject(obj);
			if (ret != null && obj.getIdProductsConfigProducts() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdProductsConfigProducts() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdProductsConfigProducts() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************END*********************************************************

}
