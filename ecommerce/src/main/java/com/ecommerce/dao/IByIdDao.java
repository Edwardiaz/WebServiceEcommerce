package com.ecommerce.dao;

import com.ecommerce.entity.*;

public interface IByIdDao {
	public Settings getSettingsShopById(Long id);  // RETRIEVE SINGLE SettingsShop
	public Email getEmailById(Long id);            // RETRIEVE SINGLE Email
	public State getStateById(Long id);            // RETRIEVE SINGLE State
	public TimeZone getTimeZoneById(Long id);      // RETRIEVE SINGLE TimeZone
	public Telephone getTelephoneById(Long id);    // RETRIEVE SINGLE Telephone
	public Address getAddressById(Long id);        // RETRIEVE SINGLE Address
	public Country getCountryById(Long id);        // RETRIEVE SINGLE Country
	
	public BillingAddress getBillingAddressById(Long id);               // RETRIEVE SINGLE BillingAddress
	public Client getClientById(Long id);                               // RETRIEVE SINGLE Client
	public CategoryClient getCategoryClientById(Long id);               // RETRIEVE SINGLE CategoryClient
	public ClientCategoryClient getClientCategoryClientById(Long id);   // RETRIEVE SINGLE ClientCategoryClient
	public Invoice getInvoiceById(Long id);                             // RETRIEVE SINGLE Invoice
	public InvoiceDetail getInvoiceDetailById(Long id);                 // RETRIEVE SINGLE InvoiceDetail
	public Orders getOrdersById(Long id);                               // RETRIEVE SINGLE Orders
	public OrdersDetail getOrdersDetailById(Long id);                   // RETRIEVE SINGLE OrdersDetail
	public OrderStatus getOrderStatusById(Long id);                     // RETRIEVE SINGLE OrdersDetail
	
	public Combo getComboById(Long id);						//Retrieve single combo
	public ComboProducts getComboProductsById(Long id); 	//Retrieve single comboProduct
	public Client customerLogin(Client cl);                 //Login SINGLE Client
	public Users adminsLogin(Users us);                     //Login SINGLE Admin
	
	public Status getStatusById(Long id);                                  // RETRIEVE SINGLE Status
	public Promotions getPromotionsById(Long id);                          // RETRIEVE SINGLE Promotions
	public TypeAttribute getTypeAttributeById(Long id);                    // RETRIEVE SINGLE TypeAttribute
	public ConfigProducts getConfigProductsById(Long id);                  // RETRIEVE SINGLE ConfigProducts
	public ConfigPromotions getConfigPromotionsById(Long id);              // RETRIEVE SINGLE ConfigPromotions
	public ProductsConfigProducts getProductsConfigProductsById(Long id);  // RETRIEVE SINGLE ProductsConfigProducts
	public Supplier getSupplierById(Long id);                              // RETRIEVE SINGLE Supplier
	public ProductsSupplier getProductsSupplierById(Long id);              // RETRIEVE SINGLE ProductsSupplier
}
