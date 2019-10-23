package com.ecommerce.controller;

import java.util.Date;
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

import com.ecommerce.entity.Users;
import com.ecommerce.entity.UsersRole;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IUsersRoleService;
import com.ecommerce.service.IUsersService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class UserController {

	private IUsersService intService;
	private IUsersRoleService usersRoleS;
	private IGenericService genS;

	// DEPENDENCY INJECTION
	@Autowired
	public UserController(IUsersService intService, IUsersRoleService usersRoleS, IGenericService genS) {
		this.intService = intService;
		this.usersRoleS = usersRoleS;
		this.genS = genS;
	}

	//HERE WE HAVE BASIC CRUDS FOR USERS AND UsersRole
	// ***********************************************Users************************************************************

	// SHOW COMPLETE LIST USERS
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Users> findAllUsers() {
		List<Users> listUsers = intService.listUsers();
		return listUsers;
	}

	// SAVE NEW SINGLE USERS
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = {	MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveUsers(@RequestBody Users users) {
		
		
		if (users.getIdUsers() == null || users.getIdUsers() == 0) {
			users.setCreationDate(new Date()); //Setting date from the system
			users.setUpdateDate(null); //Since User is new, updateDate is null
			return new ResponseEntity<>(intService.saveUsers(users), HttpStatus.CREATED); // DAO to save new one
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ENTRY USERS
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateUsers(@PathVariable("id") Long id, @RequestBody Users users) {
		
		if (users.getIdUsers() == id) {
			Users u = intService.usersbyId(id); //Retrieving the object with the id
			if(u != null) {
			users.setCreationDate(u.getCreationDate()); //Setting Creation date from DB
			}else {
				users.setCreationDate(null);
			}
			users.setUpdateDate(new Date()); //Setting up date from the system
			Users p = (Users) genS.updateObject(users); //Once Updated object 
			if (p != null && users.getIdUsers() != null) { 
				return new ResponseEntity<>(users, HttpStatus.OK); // return statement successful
			} else if ( p == null && users.getIdUsers() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if ( p == null && users.getIdUsers() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}

	// DELETE SINGLE ENTRY USERS
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteUsers(@PathVariable("id") Long idobj) {
		Users obj = new Users();
		obj.setIdUsers(idobj);

		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	// RETRIEVE SINGLE USER
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> userById(@PathVariable("id") Long idUsers) {
		Users u = intService.usersbyId(idUsers);
	
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// *************************************************UsersRole*********************************************************

	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/usersRole", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<UsersRole> findAllUsersRole() {
		List<UsersRole> list = usersRoleS.findAll();
		return list;
	}

	// RETRIEVE SINGLE
	@RequestMapping(value = "/usersRole/{id}", method = RequestMethod.GET, produces = {	MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> usersRoleById(@PathVariable("id") Long idobj) {
		UsersRole object = usersRoleS.getOne(idobj);

		if (object != null) {
			return new ResponseEntity<>(object, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// SAVE NEW SINGLE UsersRole
	@RequestMapping(value = "/usersRole", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveUsersRole(@RequestBody UsersRole obj) {
		
		
		if (obj.getIdUseRole() == null || obj.getIdUseRole() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ENTRY UsersRole
	@RequestMapping(value = "/usersRole/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateUsersRole(@PathVariable("id") Long id, @RequestBody UsersRole obj) {
				
		if (obj.getIdUseRole() == id) {

			UsersRole u = (UsersRole) genS.updateObject(obj);
			if (u != null && obj.getIdUseRole() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if ( u == null && obj.getIdUseRole() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if ( u == null && obj.getIdUseRole() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}

	// DELETE SINGLE ENTRY USERS
	@RequestMapping(value = "/usersRole/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteUsersRole(@PathVariable("id") Long idobj) {
		UsersRole obj = new UsersRole();
		obj.setIdUseRole(idobj);
		
		boolean msj = genS.deleteObject(obj);

		if (msj) {
			return new ResponseEntity<>(msj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
		}
	}

	
}
