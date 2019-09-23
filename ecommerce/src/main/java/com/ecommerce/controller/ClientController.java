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

import com.ecommerce.entity.BillingAddress;
import com.ecommerce.entity.CategoryClient;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.ClientCategoryClient;
import com.ecommerce.service.IAllListService;
import com.ecommerce.service.IByIdService;
import com.ecommerce.service.IGenericService;

@RestController
@RequestMapping("/api")
public class ClientController {

	private IGenericService genS;
	private IAllListService listS;
	private IByIdService byIdS;

	// DEPENDENCY INJECTIONS
	@Autowired
	public ClientController(IGenericService genS, IAllListService listS, IByIdService byIdS) {
		this.genS = genS;
		this.listS = listS;
		this.byIdS = byIdS;
	}

	// Here we have BillingAddress, Client, CategoryClient, ClientCategoryClient
	// *************************************************BillingAddress*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/billingAddress", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<BillingAddress> findAllBillingAddress() {
		return listS.allBillingAddress();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/billingAddress/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> billingAddressById(@PathVariable("id") Long id) {
		BillingAddress obj = byIdS.getBillingAddressById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/billingAddress/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteBillingAddress(@PathVariable("id") Long id) {
		BillingAddress obj = new BillingAddress();
		obj.setIdBillingAddress(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			System.out.println("Hibernate: Trying to delete non existent field");
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/billingAddress", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveBillingAddress(@RequestBody BillingAddress obj) {
		if (obj.getIdBillingAddress() == null || obj.getIdBillingAddress() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/billingAddress/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateBillingAddress(@PathVariable("id") Long id, @RequestBody BillingAddress obj) {
		if (obj.getIdBillingAddress() == id) {
			BillingAddress ret = (BillingAddress) genS.updateObject(obj);
			if (ret != null && obj.getIdBillingAddress() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdBillingAddress() != null) {
				System.out.println("Hibernate: Trying to update non existing id");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdBillingAddress() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	// *************************************************Client*********************************************************

	// SHOW COMPLETE LIST USERS
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/client", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Client> findAllClient() {
		return listS.allClient();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> clientById(@PathVariable("id") Long id) {
		Client obj = byIdS.getClientById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
		Client obj = new Client();
		obj.setIdClient(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/client", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveClient(@RequestBody Client obj) {
		if (obj.getIdClient() == null || obj.getIdClient() == 0) {
			obj.setRegistrationDate(new Date()); // Setting date from the system
			obj.setUpdateDate(null); // Since it is new, updateDate is null
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody Client obj) {
		if (obj.getIdClient() == id) {
			Client s = byIdS.getClientById(id);
			if (s != null) { // Validate if such field exists
				obj.setRegistrationDate(s.getRegistrationDate());
			} else {
				obj.setRegistrationDate(null);
			} // End and continue as normal
			obj.setUpdateDate(new Date());
			Client upd = (Client) genS.updateObject(obj);
			if (upd != null && obj.getIdClient() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (upd == null && obj.getIdClient() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (upd == null && obj.getIdClient() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	// *************************************************CategoryClient*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/categoryClient", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<CategoryClient> findAllCategoryClient() {
		return listS.allCategoryClient();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/categoryClient/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> categoryClientById(@PathVariable("id") Long id) {
		CategoryClient obj = byIdS.getCategoryClientById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/categoryClient/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteCategoryClient(@PathVariable("id") Long id) {
		CategoryClient obj = new CategoryClient();
		obj.setIdCategoryClient(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/categoryClient", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveCategoryClient(@RequestBody CategoryClient obj) {
		if (obj.getIdCategoryClient() == null || obj.getIdCategoryClient() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/categoryClient/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateCategoryClient(@PathVariable("id") Long id, @RequestBody CategoryClient obj) {
		if (obj.getIdCategoryClient() == id) {
			CategoryClient ret = (CategoryClient) genS.updateObject(obj);
			if (ret != null && obj.getIdCategoryClient() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdCategoryClient() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdCategoryClient() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************ClientCategoryClient*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/clientCategoryClient", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ClientCategoryClient> findAllClientCategoryClient() {
		return listS.allClientCategoryClient();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/clientCategoryClient/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> ClientCategoryClientById(@PathVariable("id") Long id) {
		ClientCategoryClient obj = byIdS.getClientCategoryClientById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/clientCategoryClient/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteClientCategoryClient(@PathVariable("id") Long id) {
		ClientCategoryClient obj = new ClientCategoryClient();
		obj.setIdClientCategoryClient(id);
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/clientCategoryClient", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveClientCategoryClient(@RequestBody ClientCategoryClient obj) {
		if (obj.getIdClientCategoryClient() == null || obj.getIdClientCategoryClient() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/clientCategoryClient/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateSettingsShop(@PathVariable("id") Long id, @RequestBody ClientCategoryClient obj) {
		if (obj.getIdClientCategoryClient() == id) {
			ClientCategoryClient ret = (ClientCategoryClient) genS.updateObject(obj);
			if (ret != null && obj.getIdClientCategoryClient() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdClientCategoryClient() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdClientCategoryClient() == null) {
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
