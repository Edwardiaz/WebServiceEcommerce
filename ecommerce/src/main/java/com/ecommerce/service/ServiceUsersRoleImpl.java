package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IUsersRoleDao;
import com.ecommerce.entity.UsersRole;

@Service
public class ServiceUsersRoleImpl implements IUsersRoleService{

	IUsersRoleDao usersRoleD;
	
	@Autowired
	public ServiceUsersRoleImpl(IUsersRoleDao usersRoleD) {
		this.usersRoleD = usersRoleD;
	}
	
	
	@Override
	public List<UsersRole> findAll() {
		return usersRoleD.findAll();
	}

	@Override
	public UsersRole getOne(Long id) {
		return usersRoleD.getOne(id);
	}

}
