package com.feedback.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.feedback.dao.ProductDAO;
import com.feedback.entity.Feedback;
import com.feedback.entity.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDAO dao;
	
	@GetMapping("/add")
	public ModelAndView showProductForm() {
		return new ModelAndView("add");
	}
	
	@PostMapping("/products")
	public ModelAndView addProduct(@RequestParam("name")String name, HttpServletRequest request) {
		Product product = new Product();
		product.setName(name);
		dao.save(product);
		List<Product> products = (List<Product>)dao.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		return new ModelAndView("products");
	}
	
	@GetMapping("/products")
	public ModelAndView showAllProducts(HttpServletRequest request) {	
	List<Product> products = (List<Product>)dao.findAll();
	HttpSession session = request.getSession();
	session.setAttribute("products", products);
	return new ModelAndView("products");
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView showProduct(@PathVariable("id")int id, HttpServletRequest request) {
		Product product = dao.findById(id).get();
		List<Feedback> fs = product.getFeedbacks();
		Collections.sort(fs, new FeedbackComparator());
		HttpSession session = request.getSession();
		session.setAttribute("fs", fs);
		return new ModelAndView("/view").addObject("product", product);
	}
	
	@PostMapping("/view/{id}")
	public ModelAndView addReview(@PathVariable("id") int id, @RequestParam("review") String review, HttpServletRequest request) {
		Product product = dao.findById(id).get();
		Feedback feedback = new Feedback(review);
		product.getFeedbacks().add(feedback);
		feedback.setProduct(product);
		dao.save(product);
		List<Feedback> fs = product.getFeedbacks();
		Collections.sort(fs, new FeedbackComparator());
		HttpSession session = request.getSession();
		session.setAttribute("fs", fs);
		return new ModelAndView("/view").addObject("product", product);
	}
	
}
