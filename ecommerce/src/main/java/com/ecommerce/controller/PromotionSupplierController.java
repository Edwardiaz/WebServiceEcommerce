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

import com.ecommerce.entity.ProductsSupplier;
import com.ecommerce.entity.Promotions;
import com.ecommerce.entity.Status;
import com.ecommerce.entity.Supplier;
import com.ecommerce.service.IAllListService;
import com.ecommerce.service.IByIdService;
import com.ecommerce.service.IGenericService;

@RestController
@RequestMapping(value = "/api")
public class PromotionSupplierController {

	private IGenericService genS;
	private IAllListService listS;
	private IByIdService byIdS;

	// DEPENDENCY INJECTIONS
	@Autowired
	public PromotionSupplierController(IGenericService genS, IAllListService listS, IByIdService byIdS) {
		this.genS = genS;
		this.listS = listS;
		this.byIdS = byIdS;
	}

	// Here we have Status, Promotions, Supplier, ProductsSupplier
	// *************************************************Status*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Status> findAllStatus() {
		return listS.allStatus();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/status/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> statusById(@PathVariable("id") Long id) {
		Status obj = byIdS.getStatusById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/status/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteStatus(@PathVariable("id") Long id) {
		Status obj = new Status();
		obj.setIdStatus(id);
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

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/status", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveStatus(@RequestBody Status obj) {
		if (obj.getIdStatus() == null || obj.getIdStatus() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/status/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateStatus(@PathVariable("id") Long id, @RequestBody Status obj) {
		if (obj.getIdStatus() == id) {
			Status ret = (Status) genS.updateObject(obj);
			if (ret != null && obj.getIdStatus() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdStatus() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdStatus() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************Promotions*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/promotions", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Promotions> findAllPromotions() {
		return listS.allPromotions();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/promotions/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> promotionsById(@PathVariable("id") Long id) {
		Promotions obj = byIdS.getPromotionsById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/promotions/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deletePromotions(@PathVariable("id") Long id) {
		Promotions obj = new Promotions();
		obj.setIdPromotions(id);
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

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/promotions", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> savePromotions(@RequestBody Promotions obj) {
		if (obj.getIdPromotions() == null || obj.getIdPromotions() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/promotions/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updatePromotions(@PathVariable("id") Long id, @RequestBody Promotions obj) {
		if (obj.getIdPromotions() == id) {
			Promotions ret = (Promotions) genS.updateObject(obj);
			if (ret != null && obj.getIdPromotions() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdPromotions() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdPromotions() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************Supplier*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/supplier", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Supplier> findAllSupplier() {
		return listS.allSupplier();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> supplierById(@PathVariable("id") Long id) {
		Supplier obj = byIdS.getSupplierById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteSupplier(@PathVariable("id") Long id) {
		Supplier obj = new Supplier();
		obj.setIdSupplier(id);
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

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/supplier", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveSettingsShop(@RequestBody Supplier obj) {
		if (obj.getIdSupplier() == null || obj.getIdSupplier() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateSettingsShop(@PathVariable("id") Long id, @RequestBody Supplier obj) {
		if (obj.getIdSupplier() == id) {
			Supplier ret = (Supplier) genS.updateObject(obj);
			if (ret != null && obj.getIdSupplier() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdSupplier() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdSupplier() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************ProductsSupplier*********************************************************
	// SHOW COMPLETE LIST
		@ResponseStatus(code = HttpStatus.FOUND)
		@RequestMapping(value = "/productsSupplier", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public List<ProductsSupplier> findAllProductsSupplier() {
			return listS.allProductsSupplier();
		}
		
		// RETRIEVE SINGLE ELEMENT
		@RequestMapping(value = "/productsSupplier/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> productsSupplierById(@PathVariable("id") Long id) {
			ProductsSupplier obj = byIdS.getProductsSupplierById(id);
			if (obj != null) {
				return new ResponseEntity<>(obj, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
		
		// DELETE SINGLE ELEMENT
		@RequestMapping(value = "/productsSupplier/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> deleteProductsSupplier(@PathVariable("id") Long id) {
			ProductsSupplier obj = new ProductsSupplier();
			obj.setIdProductSupplier(id);
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
		
		// SAVE NEW SINGLE ELEMENT
		@RequestMapping(value = "/productsSupplier", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> saveProductsSupplier(@RequestBody ProductsSupplier obj) {
			if (obj.getIdProductSupplier() == null || obj.getIdProductSupplier() == 0) {
				return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		
		// UPDATE SINGLE ELEMENT
		@RequestMapping(value = "/productsSupplier/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> updateSettingsShop(@PathVariable("id") Long id, @RequestBody ProductsSupplier obj) {
			if (obj.getIdProductSupplier() == id) {
				ProductsSupplier ret = (ProductsSupplier) genS.updateObject(obj);
				if (ret != null && obj.getIdProductSupplier() != null) {
					return new ResponseEntity<>(obj, HttpStatus.OK);
				} else if (ret == null && obj.getIdProductSupplier() != null) {
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
				} else if (ret == null && obj.getIdProductSupplier() == null) {
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
