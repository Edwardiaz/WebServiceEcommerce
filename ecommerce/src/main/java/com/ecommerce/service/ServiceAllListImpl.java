package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IAllListDao;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.BillingAddress;
import com.ecommerce.entity.CategoryClient;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.ClientCategoryClient;
import com.ecommerce.entity.Country;
import com.ecommerce.entity.State;
import com.ecommerce.entity.Email;
import com.ecommerce.entity.Invoice;
import com.ecommerce.entity.InvoiceDetail;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.OrdersDetail;
import com.ecommerce.entity.Settings;
import com.ecommerce.entity.Telephone;
import com.ecommerce.entity.TimeZone;

@Service
public class ServiceAllListImpl implements IAllListService {

	private IAllListDao allList;
	
	@Autowired
	public ServiceAllListImpl(IAllListDao allList) {
		this.allList = allList;
	}
	
	@Override
	public List<Settings> allSettingsShop() {
		return allList.allSettingsShop();
	}

	@Override
	public List<Email> allEmail() {
		return allList.allEmail();
	}

	@Override
	public List<State> allState() {
		return allList.allState();
	}

	@Override
	public List<TimeZone> allTimeZone() {
		return allList.allTimeZone();
	}

	@Override
	public List<Telephone> allTelephone() {
		return allList.allTelephone();
	}

	@Override
	public List<Address> allAddress() {
		return allList.allAddress();
	}

	@Override
	public List<Country> allCountry() {
		return allList.allCountry();
	}
	//*********************************************************************************

	@Override
	public List<BillingAddress> allBillingAddress() {
		return allList.allBillingAddress();
	}

	@Override
	public List<Client> allClient() {
		return allList.allClient();
	}

	@Override
	public List<ClientCategoryClient> allClientCategoryClient() {
		return allList.allClientCategoryClient();
	}

	@Override
	public List<Invoice> allInvoice() {
		return allList.allInvoice();
	}

	@Override
	public List<InvoiceDetail> allInvoiceDetail() {
		return allList.allInvoiceDetail();
	}

	@Override
	public List<Orders> allOrders() {
		return allList.allOrders();
	}

	@Override
	public List<OrdersDetail> allOrdersDetail() {
		return allList.allOrdersDetail();
	}

	@Override
	public List<OrderStatus> allOrderStatus() {
		return allList.allOrderStatus();
	}

	@Override
	public List<CategoryClient> allCategoryClient() {
		return allList.allCategoryClient();
	}

}
