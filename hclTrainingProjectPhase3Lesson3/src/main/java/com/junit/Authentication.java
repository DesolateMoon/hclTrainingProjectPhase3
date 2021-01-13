package com.junit;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.junit.model.User;

public class Authentication {
	
	public static Set<User> userList = new HashSet<>();
	
	private User currentSessionUser = null;

	public boolean login(String userName, String password) {
		AtomicBoolean userExists = new AtomicBoolean(false);
		userList.stream().filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password)).findFirst()
					.ifPresent(x -> {
						userExists.set(true);
						currentSessionUser = x;
						});
		return userExists.get();
	}

	public String getRole() {
		if(currentSessionUser != null) {
			return currentSessionUser.getRole();
		}
		return null;
	}
	
	public String getUserName() {
		if(currentSessionUser != null) {
			return currentSessionUser.getUserName();
		}
		return null;
	}
	
	public void logout() {
		currentSessionUser = null;
	}
}
