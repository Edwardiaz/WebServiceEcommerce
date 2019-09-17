package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.*;

public interface IAllListService {

	public List<Settings> allSettingsShop();     // SettingsShop  General List
	public List<Email> allEmail();               // Email  General List
	public List<State> allState();               // City  General List
	public List<TimeZone> allTimeZone();         // TimeZone  General List
	public List<Telephone> allTelephone();       // Telephone  General List
	public List<Address> allAddress();           // Address  General List
	public List<Country> allCountry();           // Country  General List
	
	public List<BillingAddress> allBillingAddress();              // BillingAddress  General List
	public List<Client> allClient();                              // Client  General List
	public List<CategoryClient> allCategoryClient();              // ClientCategoryClient  General List
	public List<ClientCategoryClient> allClientCategoryClient();  // ClientCategoryClient  General List
	
	public List<Invoice> allInvoice();                            // Invoice  General List
	public List<InvoiceDetail> allInvoiceDetail();                // InvoiceDetail  General List
	public List<Orders> allOrders();                              // Orders  General List
	public List<OrdersDetail> allOrdersDetail();                  // OrdersDetail  General List
	public List<OrderStatus> allOrderStatus();                    // OrderStatus  General List
	
}
