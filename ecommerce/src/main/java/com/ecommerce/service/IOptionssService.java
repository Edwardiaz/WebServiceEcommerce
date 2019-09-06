package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Optionss;

public interface IOptionssService {
	public List<Optionss> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public Optionss getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT
}
