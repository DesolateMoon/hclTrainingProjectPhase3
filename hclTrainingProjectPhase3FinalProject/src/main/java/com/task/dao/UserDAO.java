package com.task.dao;

import org.springframework.data.repository.CrudRepository;

import com.task.entity.User;

public interface UserDAO extends CrudRepository<User, String>{

}
