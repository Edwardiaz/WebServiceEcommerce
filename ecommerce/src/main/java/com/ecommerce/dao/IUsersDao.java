package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Users;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersDao extends JpaRepository<Users, Integer>{
	public List<Users> findAll();
	
	public Users update(Users use);
	
	public Users saver (Users ob);
	
	public Users userbyId(Long id);

}
