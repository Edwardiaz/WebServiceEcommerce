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

import com.ecommerce.entity.*;
import com.ecommerce.service.IAllListService;
import com.ecommerce.service.IByIdService;
import com.ecommerce.service.IGenericService;

@RestController
@RequestMapping(value = "/api")
public class SettingsController {

	private IGenericService genS;
	private IAllListService listS;
	private IByIdService byIdS;

	// DEPENDENCY INJECTIONS
	@Autowired
	public SettingsController(IGenericService genS, IAllListService listS, IByIdService byIdS) {
		this.genS = genS;
		this.listS = listS;
		this.byIdS = byIdS;
	}

	// Here we have SettingsShop, Email, State, TimeZone, Telephone, Address, Country
	// *************************************************SettingsShop*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/settings", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Settings> findAllSettingsShop() {
		return listS.allSettingsShop();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/settings/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> settingsShopById(@PathVariable("id") Long id) {
		Settings obj = byIdS.getSettingsShopById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/settings/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteSettingsShop(@PathVariable("id") Long id) {
		Settings obj = new Settings();
		obj.setIdSettings(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/settings", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveSettingsShop(@RequestBody Settings obj) {
		if (obj.getIdSettings() == null || obj.getIdSettings() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/settings/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateSettingsShop(@PathVariable("id") Long id, @RequestBody Settings obj) {
		if (obj.getIdSettings() == id) {
			Settings ret = (Settings) genS.updateObject(obj);
			if (ret != null && obj.getIdSettings() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdSettings() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdSettings() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************Email*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/email", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Email> findAllEmail() {
		return listS.allEmail();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/email/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> emailById(@PathVariable("id") Long id) {
		Email obj = byIdS.getEmailById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/email/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteEmail(@PathVariable("id") Long id) {
		Email obj = new Email();
		obj.setIdEmail(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/email", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveEmail(@RequestBody Email obj) {
		if (obj.getIdEmail() == null || obj.getIdEmail() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/email/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateEmail(@PathVariable("id") Long id, @RequestBody Email obj) {
		if (obj.getIdEmail() == id) {
			Email ret = (Email) genS.updateObject(obj);
			if (ret != null && obj.getIdEmail() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdEmail() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdEmail() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************State*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/state", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<State> findAllState() {
		return listS.allState();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/state/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> stateById(@PathVariable("id") Long id) {
		State obj = byIdS.getStateById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/state/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteState(@PathVariable("id") Long id) {
		State obj = new State();
		obj.setIdState(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/state", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveState(@RequestBody State obj) {
		if (obj.getIdState() == null || obj.getIdState() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/state/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateState(@PathVariable("id") Long id, @RequestBody State obj) {
		if (obj.getIdState() == id) {
			State ret = (State) genS.updateObject(obj);
			if (ret != null && obj.getIdState() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdState() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdState() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	// *************************************************TimeZone*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/timeZone", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<TimeZone> findAllTimeZone() {
		return listS.allTimeZone();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/timeZone/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> timeZoneById(@PathVariable("id") Long id) {
		TimeZone obj = byIdS.getTimeZoneById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/timeZone/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteTimeZone(@PathVariable("id") Long id) {
		TimeZone obj = new TimeZone();
		obj.setIdTimeZone(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/timeZone", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveTimeZone(@RequestBody TimeZone obj) {
		if (obj.getIdTimeZone() == null || obj.getIdTimeZone() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/timeZone/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateTimeZone(@PathVariable("id") Long id, @RequestBody TimeZone obj) {
		if (obj.getIdTimeZone() == id) {
			TimeZone ret = (TimeZone) genS.updateObject(obj);
			if (ret != null && obj.getIdTimeZone() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdTimeZone() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdTimeZone() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}
	// *************************************************Telephone*********************************************************
	
	// SHOW COMPLETE LIST
		@ResponseStatus(code = HttpStatus.FOUND)
		@RequestMapping(value = "/telephone", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public List<Telephone> findAllTelephone() {
			return listS.allTelephone();
		}

		// RETRIEVE SINGLE ELEMENT
		@RequestMapping(value = "/telephone/{id}", method = RequestMethod.GET, produces = {	MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> telephoneById(@PathVariable("id") Long id) {
			Telephone obj = byIdS.getTelephoneById(id);
			if (obj != null) {
				return new ResponseEntity<>(obj, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}

		// DELETE SINGLE ELEMENT
		@RequestMapping(value = "/telephone/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> deleteTelephone(@PathVariable("id") Long id) {
			Telephone obj = new Telephone();
			obj.setIdTelephone(id);
			boolean msj = genS.deleteObject(obj, id);

			if (msj) {
				return new ResponseEntity<>(msj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
			}
		}

		// SAVE NEW SINGLE ELEMENT
		@RequestMapping(value = "/telephone", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> saveTelephone(@RequestBody Telephone obj) {
			if (obj.getIdTelephone() == null || obj.getIdTelephone() == 0) {
				return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}

		// UPDATE SINGLE ELEMENT
		@RequestMapping(value = "/telephone/{id}", method = RequestMethod.PUT, produces = {	MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> updateTelephone(@PathVariable("id") Long id, @RequestBody Telephone obj) {
			if (obj.getIdTelephone() == id) {
				Telephone ret = (Telephone) genS.updateObject(obj);
				if (ret != null && obj.getIdTelephone() != null) {
					return new ResponseEntity<>(obj, HttpStatus.OK);
				} else if (ret == null && obj.getIdTelephone() != null) {
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
				} else if (ret == null && obj.getIdTelephone() == null) {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				} else {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}

			} else {

				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

			}

		}
		
		// *************************************************Address*********************************************************
		
		// SHOW COMPLETE LIST
		@ResponseStatus(code = HttpStatus.FOUND)
		@RequestMapping(value = "/address", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public List<Address> findAllAddress() {
			return listS.allAddress();
		}

		// RETRIEVE SINGLE ELEMENT
		@RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> addressById(@PathVariable("id") Long id) {
			Address obj = byIdS.getAddressById(id);
			if (obj != null) {
				return new ResponseEntity<>(obj, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}

		// DELETE SINGLE ELEMENT
		@RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> deleteAddress(@PathVariable("id") Long id) {
			Address obj = new Address();
			obj.setIdAddress(id);
			boolean msj = genS.deleteObject(obj, id);

			if (msj) {
				return new ResponseEntity<>(msj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
			}
		}

		// SAVE NEW SINGLE ELEMENT
		@RequestMapping(value = "/address", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> saveAddress(@RequestBody Address obj) {
			if (obj.getIdAddress() == null || obj.getIdAddress() == 0) {
				return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}

		// UPDATE SINGLE ELEMENT
		@RequestMapping(value = "/address/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
		@ResponseBody
		public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody Address obj) {
			if (obj.getIdAddress() == id) {
				Address ret = (Address) genS.updateObject(obj);
				if (ret != null && obj.getIdAddress() != null) {
					return new ResponseEntity<>(obj, HttpStatus.OK);
				} else if (ret == null && obj.getIdAddress() != null) {
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
				} else if (ret == null && obj.getIdAddress() == null) {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				} else {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}

			} else {

				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

			}

		}
		
	// *************************************************Country*********************************************************
		
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/country", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Country> findAllCountry() {
		return listS.allCountry();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> countryById(@PathVariable("id") Long id) {
		Country obj = byIdS.getCountryById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id) {
		Country obj = new Country();
		obj.setIdCountry(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/country", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveCountry(@RequestBody Country obj) {
		if (obj.getIdCountry() == null || obj.getIdCountry() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/country/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody Country obj) {
		if (obj.getIdCountry() == id) {
			Country ret = (Country) genS.updateObject(obj);
			if (ret != null && obj.getIdCountry() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdCountry() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdCountry() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}
	
	
}
