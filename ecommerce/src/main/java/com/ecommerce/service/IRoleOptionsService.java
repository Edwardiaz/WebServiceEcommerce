package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.RoleOptions;

public interface IRoleOptionsService {
	public List<RoleOptions> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public RoleOptions getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT
}
