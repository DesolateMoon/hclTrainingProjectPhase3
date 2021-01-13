package com.search.dao;

import java.util.List;

import com.search.model.User;

public interface UserDAO {
	
	public User getUserById(Integer id);
	
	public List<User> getAllUsers();

	public void addUser(User user);
	
	public void modifyUser(User user);
	
	public void deleteUser(Integer id);
}
