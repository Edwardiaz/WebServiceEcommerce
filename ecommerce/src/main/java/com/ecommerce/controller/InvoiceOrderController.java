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

import com.ecommerce.entity.Invoice;
import com.ecommerce.entity.InvoiceDetail;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.OrdersDetail;
import com.ecommerce.service.IAllListService;
import com.ecommerce.service.IByIdService;
import com.ecommerce.service.IGenericService;

@RestController
@RequestMapping("/api")
public class InvoiceOrderController {

	private IGenericService genS;
	private IAllListService listS;
	private IByIdService byIdS;

	// DEPENDENCY INJECTIONS
	@Autowired
	public InvoiceOrderController(IGenericService genS, IAllListService listS, IByIdService byIdS) {
		this.genS = genS;
		this.listS = listS;
		this.byIdS = byIdS;
	}

	// Here we have Invoice, InvoiceDetail, Orders, OrdersDetail, OrderStatus
	// *************************************************Invoice*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/invoice", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Invoice> findAllInvoice() {
		return listS.allInvoice();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> invoiceById(@PathVariable("id") Long id) {
		Invoice obj = byIdS.getInvoiceById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id) {
		Invoice obj = new Invoice();
		obj.setIdInvoice(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/invoice", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveInvoice(@RequestBody Invoice obj) {
		if (obj.getIdInvoice() == null || obj.getIdInvoice() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice obj) {
		if (obj.getIdInvoice() == id) {
			Invoice ret = (Invoice) genS.updateObject(obj);
			if (ret != null && obj.getIdInvoice() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdInvoice() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdInvoice() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	// *************************************************InvoiceDetail*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/invoiceDetail", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<InvoiceDetail> findAllInvoiceDetail() {
		return listS.allInvoiceDetail();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/invoiceDetail/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> invoiceDetailById(@PathVariable("id") Long id) {
		InvoiceDetail obj = byIdS.getInvoiceDetailById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/invoiceDetail/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteInvoiceDetail(@PathVariable("id") Long id) {
		InvoiceDetail obj = new InvoiceDetail();
		obj.setIdInvoiceDetail(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/invoiceDetail", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveInvoiceDetail(@RequestBody InvoiceDetail obj) {
		if (obj.getIdInvoiceDetail() == null || obj.getIdInvoiceDetail() == 0) {
			obj.setInvoiceDate(new Date());
		return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/invoiceDetail/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateInvoiceDetail(@PathVariable("id") Long id, @RequestBody InvoiceDetail obj) {
		if (obj.getIdInvoiceDetail() == id) {
			
			InvoiceDetail s = byIdS.getInvoiceDetailById(id);
			if (s != null) { // Validate if such field exists
				obj.setInvoiceDate(s.getInvoiceDate());
			} else {
				obj.setInvoiceDate(null);
			} // End and continue as normal
			obj.setDateInvoice(new Date());
			InvoiceDetail ret = (InvoiceDetail) genS.updateObject(obj);
			if (ret != null && obj.getIdInvoiceDetail() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdInvoiceDetail() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdInvoiceDetail() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	// *************************************************Orders*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/orders", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Orders> findAllOrders() {
		return listS.allOrders();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> ordersById(@PathVariable("id") Long id) {
		Orders obj = byIdS.getOrdersById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteOrders(@PathVariable("id") Long id) {
		Orders obj = new Orders();
		obj.setIdOrders(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/orders", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveOrders(@RequestBody Orders obj) {
		if (obj.getIdOrders() == null || obj.getIdOrders() == 0) {
			obj.setPurchaseDate(new Date());
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateOrders(@PathVariable("id") Long id, @RequestBody Orders obj) {
		if (obj.getIdOrders() == id) {
			Orders ret = (Orders) genS.updateObject(obj);
			if (ret != null && obj.getIdOrders() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdOrders() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdOrders() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	// *************************************************OrdersDetail*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/ordersDetail", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<OrdersDetail> findAllOrdersDetail() {
		return listS.allOrdersDetail();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/ordersDetail/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> ordersDetailById(@PathVariable("id") Long id) {
		OrdersDetail obj = byIdS.getOrdersDetailById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/ordersDetail/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteOrdersDetail(@PathVariable("id") Long id) {
		OrdersDetail obj = new OrdersDetail();
		obj.setIdOrdersDetails(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/ordersDetail", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveOrdersDetail(@RequestBody OrdersDetail obj) {
		if (obj.getIdOrdersDetails() == null || obj.getIdOrdersDetails() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/ordersDetail/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateOrdersDetail(@PathVariable("id") Long id, @RequestBody OrdersDetail obj) {
		if (obj.getIdOrdersDetails() == id) {
			OrdersDetail ret = (OrdersDetail) genS.updateObject(obj);
			if (ret != null && obj.getIdOrdersDetails() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdOrdersDetails() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdOrdersDetails() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	// *************************************************OrderStatus*********************************************************
	// SHOW COMPLETE LIST
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/orderStatus", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<OrderStatus> findAllOrderStatus() {
		return listS.allOrderStatus();
	}

	// RETRIEVE SINGLE ELEMENT
	@RequestMapping(value = "/orderStatus/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> orderStatuslById(@PathVariable("id") Long id) {
		OrderStatus obj = byIdS.getOrderStatusById(id);
		if (obj != null) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// DELETE SINGLE ELEMENT
	@RequestMapping(value = "/orderStatus/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> deleteOrderStatus(@PathVariable("id") Long id) {
		OrderStatus obj = new OrderStatus();
		obj.setIdOrderStatus(id);
		boolean msj = genS.deleteObject(obj, id);

		if (msj) {
			return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sorry, there was a problem deleting the file... try again!", HttpStatus.NO_CONTENT);
		}
	}

	// SAVE NEW SINGLE ELEMENT
	@RequestMapping(value = "/orderStatus", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> saveOrderStatus(@RequestBody OrderStatus obj) {
		if (obj.getIdOrderStatus() == null || obj.getIdOrderStatus() == 0) {
			return new ResponseEntity<>(genS.saveObject(obj), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE SINGLE ELEMENT
	@RequestMapping(value = "/orderStatus/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateOrderStatus(@PathVariable("id") Long id, @RequestBody OrderStatus obj) {
		if (obj.getIdOrderStatus() == id) {
			OrderStatus ret = (OrderStatus) genS.updateObject(obj);
			if (ret != null && obj.getIdOrderStatus() != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else if (ret == null && obj.getIdOrderStatus() != null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else if (ret == null && obj.getIdOrderStatus() == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
}
