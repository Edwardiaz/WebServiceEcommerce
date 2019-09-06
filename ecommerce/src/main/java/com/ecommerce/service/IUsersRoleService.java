package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.UsersRole;

public interface IUsersRoleService {
	public List<UsersRole> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public UsersRole getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT
}
