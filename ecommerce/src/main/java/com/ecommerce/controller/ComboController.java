package com.ecommerce.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.ecommerce.entity.Combo;
import com.ecommerce.entity.ComboProducts;
import com.ecommerce.service.IAllListService;
import com.ecommerce.service.IByIdService;
import com.ecommerce.service.IGenericService;

@RestController
@RequestMapping("/api")
public class ComboController {

	private Logger logger = LogManager.getLogger(ComboController.class);
	private IAllListService findAll;
	private IByIdService findById;
	private IGenericService genS;

	@Autowired
	public ComboController(IAllListService findAll, IByIdService findById, IGenericService genS) {
		this.findAll = findAll;
		this.findById = findById;
		this.genS = genS;
	}

	// create combo with a specific product
	@RequestMapping(value = "/combo/producto/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveCombo(@RequestBody Combo combo, @PathVariable("id") Long id) {
		if (combo.getIdCombo() == null || combo.getIdCombo() == 0) {
			ComboProducts comboPro = new ComboProducts();
			combo.setDate(new Date());
			Combo com = (Combo) genS.saveObject(combo);
			comboPro.setIdProducts(id);
			comboPro.setIdCombo(com.getIdCombo());
			comboPro.setDate(new Date());
			genS.saveObject(comboPro);
			return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("An error has ocurred: Make sure all the parameters are valid",HttpStatus.BAD_REQUEST);
		}
	}

	// consultar combo
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/combo", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Combo> findAllCombo() {
		List<Combo> comboList = findAll.allCombo();
		return comboList;
	}

	// consultar por id
	@RequestMapping(value = "/combo/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> findComboById(@PathVariable("id") Long id) {
		Combo combo = findById.getComboById(id);
		if (combo != null) {
			return new ResponseEntity<>(combo, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("Sorry error retrieving the result...", HttpStatus.NOT_FOUND);
		}
	}

	// deletes a combo
	@RequestMapping(value = "/combo/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteCombo(@PathVariable("id") Long id) {
		Combo combo = new Combo();
		combo.setIdCombo(id);
		boolean delMsg = genS.deleteObject(combo);

		if (delMsg) {
			return new ResponseEntity<>(delMsg, HttpStatus.OK);
		} else {
			logger.error("error deleting register...");
			return new ResponseEntity<>(delMsg, HttpStatus.NO_CONTENT);
		}
	}

	//UPDATE COMBO
	@RequestMapping(value = "/combo/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateCombo(@PathVariable("id") Long id, @RequestBody Combo combo) {
		if (combo.getIdCombo() == id) {
			Combo com = findById.getComboById(id);
			if (com != null) {
				combo.setDate(com.getDate());
			} else {
				combo.setDate(null);
			}

			Combo comb = (Combo) genS.updateObject(combo);

			if (comb != null && combo.getIdCombo() != null) {
				return new ResponseEntity<>("Register updated succesfully", HttpStatus.OK);
			} else if (comb == null && combo.getIdCombo() != null) {
				return new ResponseEntity<>("Register not found", HttpStatus.NOT_FOUND);
			} else if (comb == null && combo.getIdCombo() == null) {
				return new ResponseEntity<>("Some parameters are invalid", HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Sorry, some parameters are invalid or bad syntax in the request...",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("ID mismatch", HttpStatus.BAD_REQUEST);
		}
	}

	// method retrieve
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/procombo", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ComboProducts> getProCombo() {
		List<ComboProducts> list = findAll.allComboProducts();
		return list;
	}

	// method find by id
	@RequestMapping(value = "/procombo/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> getProComboById(@PathVariable("id") Long id) {

		ComboProducts proCombo = findById.getComboProductsById(id);

		if (proCombo != null) {
			return new ResponseEntity<>(proCombo, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("Register Not Found", HttpStatus.NOT_FOUND);
		}

	}
}
