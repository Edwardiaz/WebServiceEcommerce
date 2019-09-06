package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.Optionss;

public interface IOptionssDao {
	public List<Optionss> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public Optionss getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT
}
