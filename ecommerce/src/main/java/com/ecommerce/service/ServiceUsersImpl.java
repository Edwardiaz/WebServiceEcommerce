package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecommerce.dao.IUsersDao;
import com.ecommerce.entity.Users;

@Service
public class ServiceUsersImpl implements IUsersService{

	private IUsersDao daoUsers;
	
	@Autowired
	public ServiceUsersImpl(IUsersDao daoUsers) {
		
		this.daoUsers = daoUsers;
	}

	@Override
	public Users saveUsers(Users u) {
		return daoUsers.saver(u);
	}

	@Override
	public List<Users> listUsers() {
		return daoUsers.findAll();
	}

	public ServiceUsersImpl() {
	}

	@Override
	public Users updateUsers(Users u) {
		return daoUsers.update(u);
	}

	@Override
	public void deleteById(Integer idUsers) {
		daoUsers.deleteById(idUsers);
	}


	@Override
	public Users usersbyId(Long id) {
		return daoUsers.userbyId(id);
	}

		
	
}
