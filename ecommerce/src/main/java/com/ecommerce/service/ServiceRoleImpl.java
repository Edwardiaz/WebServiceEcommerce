package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IRoleDao;
import com.ecommerce.entity.Role;

@Service
public class ServiceRoleImpl implements IRoleService{

	private IRoleDao roleD;
	
	@Autowired
	public ServiceRoleImpl(IRoleDao roleD) {
		this.roleD = roleD;
	}
	
	@Override
	public List<Role> findAll() {
		return roleD.findAll();
	}

	@Override
	public Role getOne(Long id) {
		return roleD.getOne(id);
	}

}
