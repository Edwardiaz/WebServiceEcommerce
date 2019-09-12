package com.ecommerce.dao;

import com.ecommerce.entity.*;

public interface IByIdDao {
	public Settings getSettingsShopById(Long id); // RETRIEVE SINGLE SettingsShop
	public Email getEmailById(Long id); // RETRIEVE SINGLE Email
	public State getStateById(Long id); // RETRIEVE SINGLE State
	public TimeZone getTimeZoneById(Long id); // RETRIEVE SINGLE TimeZone
	public Telephone getTelephoneById(Long id); // RETRIEVE SINGLE Telephone
	public Address getAddressById(Long id); // RETRIEVE SINGLE Address
	public Country getCountryById(Long id); // RETRIEVE SINGLE Country
	
}
