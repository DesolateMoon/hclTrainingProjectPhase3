package com.search.service;

import java.util.List;

import com.search.model.User;

public interface UserService {
	
	public User getUserById(Integer id);
	
	public List<User> getAllUsers();
	
	public void addUser(User user);

	public void modifyUser(User user);
	
	public void deleteUser(Integer id);
}
