package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.*;

public interface IAllListService {

	public List<Settings> allSettingsShop(); // SettingsShop  General List
	public List<Email> allEmail();               // Email  General List
	public List<State> allState();                 // City  General List
	public List<TimeZone> allTimeZone();         // TimeZone  General List
	public List<Telephone> allTelephone();       // Telephone  General List
	public List<Address> allAddress();         // Address  General List
	public List<Country> allCountry();         // Country  General List
	
}
