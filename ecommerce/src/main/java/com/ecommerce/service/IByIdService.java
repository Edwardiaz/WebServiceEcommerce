package com.ecommerce.service;

import com.ecommerce.entity.*;

public interface IByIdService {
	
	public Settings getSettingsShopById(Long id);   // RETRIEVE SINGLE SettingsShop
	public Email getEmailById(Long id);             // RETRIEVE SINGLE Email
	public State getStateById(Long id);             // RETRIEVE SINGLE City
	public TimeZone getTimeZoneById(Long id);       // RETRIEVE SINGLE TimeZone
	public Telephone getTelephoneById(Long id);     // RETRIEVE SINGLE Telephone
	public Address getAddressById(Long id);         // RETRIEVE SINGLE Address
	public Country getCountryById(Long id);         // RETRIEVE SINGLE Country
	
	public BillingAddress getBillingAddressById(Long id);               // RETRIEVE SINGLE BillingAddress
	public Client getClientById(Long id);                               // RETRIEVE SINGLE Client
	public CategoryClient getCategoryClientById(Long id);               // RETRIEVE SINGLE CategoryClient
	public ClientCategoryClient getClientCategoryClientById(Long id);   // RETRIEVE SINGLE ClientCategoryClient
	
	public Invoice getInvoiceById(Long id);                             // RETRIEVE SINGLE Invoice
	public InvoiceDetail getInvoiceDetailById(Long id);                 // RETRIEVE SINGLE InvoiceDetail
	public Orders getOrdersById(Long id);                               // RETRIEVE SINGLE Orders
	public OrdersDetail getOrdersDetailById(Long id);                   // RETRIEVE SINGLE OrdersDetail
	public OrderStatus getOrderStatusById(Long id);                     // RETRIEVE SINGLE OrdersDetail
	
	public Combo getComboById(Long id);					//Retrieve single combo
	public ComboProducts getComboProductsById(Long id); 	//Retrieve single comboProduct
	
}
