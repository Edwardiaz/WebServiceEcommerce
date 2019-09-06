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

import com.ecommerce.entity.Page;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IPageService;

@RestController
@RequestMapping(value = "/api")
public class PageController {

	// DEPENDENCY INJECTION USERS
	private IPageService pageS;
	private IGenericService genS;

	@Autowired
	public PageController(IPageService pageS, IGenericService genS) {
		this.pageS = pageS;
		this.genS = genS;
	}

	
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/page", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Page> findAllProCat() {
		List<Page> list = pageS.listPage();
		return list;
	}

	
	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/page/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> userById(@PathVariable("id") Long idPage) {
		Page p = pageS.pagebyId(idPage);
		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	
	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/page/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteUsers(@PathVariable("id") Long idPage) {
		Page page = new Page();
		page.setIdPage(idPage);
		String msj = genS.deleteObject(page);

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
	@RequestMapping(value = "/page", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveUsers(@RequestBody Page page) {
		if (page.getIdPage() == null || page.getIdPage() == 0) {
			return new ResponseEntity<>(genS.saveObject(page), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	
	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/page/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateUsers(@PathVariable("id") Long id, @RequestBody Page page) {
		if (page.getIdPage() == id) {

			Page p = (Page) genS.updateObject(page);
			if (p != null && page.getIdPage() != null) {
				return new ResponseEntity<>(page, HttpStatus.OK);
			} else if ( p == null && page.getIdPage() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if ( p == null && page.getIdPage() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
		
	}

}
