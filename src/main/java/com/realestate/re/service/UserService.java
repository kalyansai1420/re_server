package com.realestate.re.service;

import java.util.Set;

import com.realestate.re.model.User;
import com.realestate.re.model.UserRole;
import com.realestate.re.payload.UserDto;

public interface UserService {

	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//update user
	public User updateUser(User user);

	//get username
	public User getUser(Long uId);

	//get user by Id
	public User getUserById(Long uId);
	
	//get all users
	public Set<User> getAllUsers();
	
	//delete user by id
	public void deleteUser(Long userId);
	
}
