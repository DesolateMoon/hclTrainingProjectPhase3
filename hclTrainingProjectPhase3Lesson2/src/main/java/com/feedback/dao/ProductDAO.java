package com.feedback.dao;

import org.springframework.data.repository.CrudRepository;

import com.feedback.entity.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {

}
