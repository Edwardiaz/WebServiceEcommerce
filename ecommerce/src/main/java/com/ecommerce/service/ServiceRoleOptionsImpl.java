package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IRoleOptionsDao;
import com.ecommerce.entity.RoleOptions;

@Service
public class ServiceRoleOptionsImpl implements IRoleOptionsService{

	private IRoleOptionsDao roleOptD;
	
	@Autowired
	public ServiceRoleOptionsImpl(IRoleOptionsDao roleOptD) {
		this.roleOptD = roleOptD;
	}
	
	@Override
	public List<RoleOptions> findAll() {
		return roleOptD.findAll();
	}

	@Override
	public RoleOptions getOne(Long id) {
		return roleOptD.getOne(id);
	}

}
