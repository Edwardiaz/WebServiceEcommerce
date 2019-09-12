package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IAllListDao;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Country;
import com.ecommerce.entity.State;
import com.ecommerce.entity.Email;
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

}
