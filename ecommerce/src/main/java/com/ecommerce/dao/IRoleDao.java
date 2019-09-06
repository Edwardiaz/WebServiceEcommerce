package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.Role;

public interface IRoleDao {
	public List<Role> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public Role getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT
}
