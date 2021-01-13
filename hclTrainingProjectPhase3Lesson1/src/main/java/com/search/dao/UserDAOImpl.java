package com.search.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.search.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager sf;
	
	public void addUser(User user) {
		sf.persist(user);
	}

	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = sf.createQuery("from User").getResultList();
		return users;
	}

	@Transactional
	public void modifyUser(User user) {
		sf.persist(user);
	}

	public void deleteUser(Integer id) {
		User user = getUserById(id);
		sf.remove(user);
	}

	public User getUserById(Integer id) {
		logger.info("getUserbyId -> {}", id);
		User user = sf.find(User.class, id);
		return user;
	}

}
