package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Users;

public interface IUsersService {
	
	public List<Users> listUsers();  //Retrieve the complete list of users

	public Users saveUsers(Users u);  //Save a new user
	
	public Users updateUsers(Users u);  //update an user entry
	
	public void deleteById(Integer idUsers); //Delete by id
	
	public Users usersbyId(Long id);   //One user by idUsers

}
