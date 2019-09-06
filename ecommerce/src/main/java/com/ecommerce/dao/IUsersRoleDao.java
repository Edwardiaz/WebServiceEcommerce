package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerce.entity.UsersRole;

@Component
public interface IUsersRoleDao {
	public List<UsersRole> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public UsersRole getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT
}
