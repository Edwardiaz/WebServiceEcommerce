package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Optionss;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.RoleOptions;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IOptionssService;
import com.ecommerce.service.IRoleOptionsService;
import com.ecommerce.service.IRoleService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class RoleController {
	private IRoleService roleS;
	private IRoleOptionsService roleOptionsS;
	private IOptionssService optionsServ;
	private IGenericService genS;

	@Autowired
	public RoleController(IRoleService roleS, IRoleOptionsService roleOptionsS, IOptionssService optionsServ,
			IGenericService genS) {
		this.roleS = roleS;
		this.roleOptionsS = roleOptionsS;
		this.optionsServ = optionsServ;
		this.genS = genS;
	}
	// Here we have Role, RoleOptions and Options
	// *************************************************Role*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/role", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Role> findAllRole() {
		List<Role> list = roleS.findAll();
		return list;
	}

	// RETRIEVE SINGLE
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> roleById(@PathVariable("id") Long idobj) {
		Role object = roleS.getOne(idobj);
		if (object != null) {
			return new ResponseEntity<>(object, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	// SAVE NEW SINGLE UsersRole
	@RequestMapping(value = "/role", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveRole(@RequestBody Role obj) {
		if (obj.getIdRole() == null || obj.getIdRole() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ENTRY UsersRole
	@RequestMapping(value = "/role/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody Role obj) {
		genS.updateObject(obj);
		
		if (obj.getIdRole() == id) {

			Role r = (Role) genS.updateObject(obj);
			if (r != null && obj.getIdRole() != null) {
				return new ResponseEntity<>(r, HttpStatus.OK);
			} else if ( r == null && obj.getIdRole() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if ( r == null && obj.getIdRole() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}

	// DELETE SINGLE ENTRY USERS
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteRole(@PathVariable("id") Long idobj) {
		Role obj = new Role();
		obj.setIdRole(idobj);

		boolean msj = genS.deleteObject(obj, idobj);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// *************************************************RoleOptions*******************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/roleOptions", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<RoleOptions> findAllRoleOptions() {
		List<RoleOptions> list = roleOptionsS.findAll();
		return list;
	}

	// RETRIEVE SINGLE
	@RequestMapping(value = "/roleOptions/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> roleOptionsById(@PathVariable("id") Long idobj) {
		RoleOptions object = roleOptionsS.getOne(idobj);

		if (object != null) {
			return new ResponseEntity<>(object, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// SAVE NEW SINGLE UsersRole
	@RequestMapping(value = "/roleOptions", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveRoleOptions(@RequestBody RoleOptions obj) {
		if (obj.getIdRoleOptions() == null || obj.getIdRoleOptions() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ENTRY UsersRole
	@RequestMapping(value = "/roleOptions/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateRoleOptions(@PathVariable("id") Long id, @RequestBody RoleOptions obj) {
				
		if (obj.getIdRoleOptions() == id) {

			RoleOptions r = (RoleOptions) genS.updateObject(obj);
			if (r != null && obj.getIdRoleOptions() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if ( r == null && obj.getIdRoleOptions() != null) {
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			} else if ( r == null && obj.getIdRoleOptions() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}

	// DELETE SINGLE ENTRY USERS
	@RequestMapping(value = "/roleOptions/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteRoleOptions(@PathVariable("id") Long idobj) {
		RoleOptions obj = new RoleOptions();
		obj.setIdRoleOptions(idobj);
		
		boolean msj = genS.deleteObject(obj, idobj);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// *************************************************Options*******************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/optionss", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Optionss> findAllOptionss() {
		List<Optionss> list = optionsServ.findAll();
		return list;
	}

	// RETRIEVE SINGLE
	@RequestMapping(value = "/optionss/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> optionssById(@PathVariable("id") Long idobj) {
		Optionss object = optionsServ.getOne(idobj);
		if (object != null) {
			return new ResponseEntity<>(object, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// SAVE NEW SINGLE UsersRole
	@RequestMapping(value = "/optionss", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveOptionss(@RequestBody Optionss obj) {

		if (obj.getIdOptionss() == null || obj.getIdOptionss() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ENTRY UsersRole
	@RequestMapping(value = "/optionss/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateOptionss(@PathVariable("id") Long id, @RequestBody Optionss obj) {
				
		if (obj.getIdOptionss() == id) {

			Optionss o = (Optionss) genS.updateObject(obj);
			if (o != null && obj.getIdOptionss() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if ( o == null && obj.getIdOptionss() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if ( o == null && obj.getIdOptionss() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
			
		}
	}

	// DELETE SINGLE ENTRY USERS
	@RequestMapping(value = "/optionss/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteOptionss(@PathVariable("id") Long idobj) {
		Optionss obj = new Optionss();
		obj.setIdOptionss(idobj);
		
		boolean msj = genS.deleteObject(obj, idobj);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

}
