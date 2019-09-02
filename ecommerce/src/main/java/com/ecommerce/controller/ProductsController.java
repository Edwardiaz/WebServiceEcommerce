package com.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.ProductsDao;
import com.ecommerce.entity.Products;


@Controller
public class ProductsController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String handler(Model m) {
		
		return "index";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String saveProducts
	(@RequestParam(value = "productCode") char productCode,
	 @RequestParam(value = "sku") String sku,
	 @RequestParam(value = "nameProducts") String nameProducts,
	 @RequestParam(value = "description") String description,
	 @RequestParam(value = "colour") String colour,
	 @RequestParam(value = "updateDate") String updateDate,
	 @RequestParam(value = "price")double price,
	 @RequestParam(value = "quantity")int quantity,
	 @RequestParam(value = "taxes") double taxes,
	 @RequestParam(value = "additionalShippingCost") double additionalShippingCost,
	 @RequestParam(value = "wholeSalePrice") double wholeSalePrice,
	 @RequestParam(value = "productDeliveryDate") String productDeliveryDate,
	 @RequestParam(value = "width") float width,
	 @RequestParam(value = "height") float height,
	 @RequestParam(value = "depth") float depth,
	 @RequestParam(value = "weight") float weight,
	 @RequestParam(value = "idOrders") int idOrders) {
		ProductsDao proDao = new ProductsDao();
		Products product = new Products();
		
		product.setProductCode(productCode);
		product.setSku(sku);
		product.setNameProducts(nameProducts);
		product.setDescription(description);
		product.setColour(colour);
		product.setUpdateDate(updateDate);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setTaxes(taxes);
		product.setAdditionalShippingCost(additionalShippingCost);
		product.setWholeSalePrice(wholeSalePrice);
		product.setProductDeliveryDate(productDeliveryDate);
		product.setWidth(width);
		product.setHeight(height);
		product.setDepth(depth);
		product.setWeight(weight);
		product.setIdOrders(idOrders);
		proDao.saveProduct(product);
		
		return "index";
	}
	
	@RequestMapping(value = "/listP")
	public String findAllProducts(Model m) {
		ProductsDao proDao = new ProductsDao();
		List<Products> listPro = proDao.findAllProducts();
		m.addAttribute("listPro", listPro);
		
		return "showProducts";
	}
	
	@RequestMapping(value = "/deletepro/{idProducts}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("idProducts") int id, Model m) {
		ProductsDao  proDao = new ProductsDao();
		proDao.deleteProduct(id);
		List<Products> listPro = proDao.findAllProducts();
		m.addAttribute("listPro", listPro);
		
		return "showProducts";
	}
	
	@RequestMapping(value = "updateProduct", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("idProducts") int id, Model m) {
		ProductsDao proDao = new ProductsDao();
		proDao.updateProduct(id);
		List<Products> listPro = proDao.findAllProducts();
		m.addAttribute("listPro", listPro);
		return "showProducts";
	}
	
	@RequestMapping(value="/updatePro/{idProducts}", method = RequestMethod.GET)
	public String findByIdProducto(@PathVariable("idProducts") int id, Model m){
		ProductsDao proDao = new ProductsDao();
		proDao.findByIdProducts(id);
		return "updateProducto";
	}
	
}
