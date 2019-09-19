package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IByIdDao;
import com.ecommerce.entity.*;

@Service
public class ServiceById implements IByIdService {

	IByIdDao byIdDao;
	
	@Autowired
	public ServiceById(IByIdDao byIdDao) {
		this.byIdDao = byIdDao;
	}
	
	@Override
	public Settings getSettingsShopById(Long id) {
		return byIdDao.getSettingsShopById(id);
	}

	@Override
	public Email getEmailById(Long id) {
		return byIdDao.getEmailById(id);
	}

	@Override
	public State getStateById(Long id) {
		return byIdDao.getStateById(id);
	}

	@Override
	public TimeZone getTimeZoneById(Long id) {
		return byIdDao.getTimeZoneById(id);
	}

	@Override
	public Telephone getTelephoneById(Long id) {
		return byIdDao.getTelephoneById(id);
	}

	@Override
	public Address getAddressById(Long id) {
		return byIdDao.getAddressById(id);
	}

	@Override
	public Country getCountryById(Long id) {
		return byIdDao.getCountryById(id);
	}
	//*********************************************************************************

	@Override
	public BillingAddress getBillingAddressById(Long id) {
		return byIdDao.getBillingAddressById(id);
	}

	@Override
	public Client getClientById(Long id) {
		return byIdDao.getClientById(id);
	}

	@Override
	public ClientCategoryClient getClientCategoryClientById(Long id) {
		return byIdDao.getClientCategoryClientById(id);
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		return byIdDao.getInvoiceById(id);
	}

	@Override
	public InvoiceDetail getInvoiceDetailById(Long id) {
		return byIdDao.getInvoiceDetailById(id);
	}

	@Override
	public Orders getOrdersById(Long id) {
		return byIdDao.getOrdersById(id);
	}

	@Override
	public OrdersDetail getOrdersDetailById(Long id) {
		return byIdDao.getOrdersDetailById(id);
	}

	@Override
	public OrderStatus getOrderStatusById(Long id) {
		return byIdDao.getOrderStatusById(id);
	}

	@Override
	public CategoryClient getCategoryClientById(Long id) {
		return byIdDao.getCategoryClientById(id);
	}

	@Override
	public Combo getComboById(Long id) {
		return byIdDao.getComboById(id);
	}

	@Override
	public ComboProducts getComboProductsById(Long id) {
		return byIdDao.getComboProductsById(id);
	}
	
}
