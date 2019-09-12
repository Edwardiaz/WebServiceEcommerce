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

}
