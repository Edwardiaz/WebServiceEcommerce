//package com.ecommerce.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ecommerce.entity.ClientCategoryClient;
//import com.ecommerce.entity.ConfigProducts;
//import com.ecommerce.entity.ConfigPromotions;
//import com.ecommerce.entity.ProductsSupplier;
//import com.ecommerce.entity.RoleOptions;
//import com.ecommerce.entity.UsersRole;
//import com.ecommerce.service.IRelationService;
//
//@RestController
//@RequestMapping(value = "/api")
//public class RelationListController {
//
//	private IRelationService relS;
//
//	// DEPENDENCY INJECTIONS
//	@Autowired
//	public RelationListController(IRelationService relS) {
//		this.relS = relS;
//	}
//
//	// SHOW RoleOptions looking by idOptionss
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/roleIdOptions/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByidOptions(@PathVariable("id") Long id) {
//		System.out.println(" ********** Id "+id);
//		List<RoleOptions> list = relS.findByidOptions(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// SHOW RoleOptions looking by idrole
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/idRoleOptions/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByidRole(@PathVariable("id") Long id) {
//		List<RoleOptions> list = relS.findByidRole(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// **********************************************************************************
//	// SHOW UsersRole looking by idRole
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/usersIdRole/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByRole(@PathVariable("id") Long id) {
//		List<UsersRole> list = relS.findByRole(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// SHOW UsersRole looking by idUsers
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/idUsersRole/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByidUsers(@PathVariable("id") Long id) {
//		List<UsersRole> list = relS.findByidUsers(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// **********************************************************************************
//	// SHOW ClientCategoryClient looking by idCategory
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/clientIdCategoryClient/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByCatClient(@PathVariable("id") Long id) {
//		List<ClientCategoryClient> list = relS.findByCatClient(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// SHOW ClientCategoryClient looking by idCategory
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/clientCategoryIdClient/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByClient(@PathVariable("id") Long id) {
//		List<ClientCategoryClient> list = relS.findByClient(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// **********************************************************************************
//	// SHOW ConfigPromotions looking by idCategory
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/configPromotionsCat/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByCategory(@PathVariable("id") Long id) {
//		List<ConfigPromotions> list = relS.findByCategory(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// SHOW ConfigPromotions looking by idProduct
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/configPromotionsProd/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByProduct(@PathVariable("id") Long id) {
//		List<ConfigPromotions> list = relS.findByProduct(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// SHOW ConfigPromotions looking by idPromotion
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/configPromotionsProm/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByPromotions(@PathVariable("id") Long id) {
//		List<ConfigPromotions> list = relS.findByPromotions(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// **********************************************************************************
//	// SHOW ConfigProducts looking by idProduct
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/configProductsProds/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByProds(@PathVariable("id") Long id) {
//		List<ConfigProducts> list = relS.findByProds(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	// SHOW ConfigProducts looking by idProduct
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/configProductsTypeAtt/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByTypeAttribute(@PathVariable("id") Long id) {
//		List<ConfigProducts> list = relS.findByTypeAttribute(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//	// **********************************************************************************
//	// SHOW ProductsSupplier looking by idProduct
//	@ResponseStatus(code = HttpStatus.FOUND)
//	@RequestMapping(value = "/idProductsSupplier/{id}", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> findByProductsSup(@PathVariable("id") Long id) {
//		List<ProductsSupplier> list = relS.findByProductsSup(id);
//		if (list != null) {
//			return new ResponseEntity<>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	// SHOW ProductsSupplier looking by idSupplier
//		@ResponseStatus(code = HttpStatus.FOUND)
//		@RequestMapping(value = "/productsIdSupplier/{id}", method = RequestMethod.GET, produces = {
//				MediaType.APPLICATION_JSON_VALUE })
//		@ResponseBody
//		public ResponseEntity<?> findBySupplier(@PathVariable("id") Long id) {
//			List<ProductsSupplier> list = relS.findBySupplier(id);
//			if (list != null) {
//				return new ResponseEntity<>(list, HttpStatus.FOUND);
//			} else {
//				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//			}
//		}
//}
