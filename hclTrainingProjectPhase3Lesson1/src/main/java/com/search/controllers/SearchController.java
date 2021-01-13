package com.search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.search.model.User;
import com.search.service.UserService;

@Controller
public class SearchController {

	@Autowired
	private UserService userService;

	@GetMapping("/search")
	public ModelAndView getUser() {
		return new ModelAndView("search");
	}
	
	@PostMapping("/search")
	public String searchValid(@RequestParam("id") int id) {
		return "redirect:/view/" + id;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		if (user != null) {
			return new ModelAndView("/view").addObject("user", user);
		}
		return new ModelAndView("error");
	}
	
	@GetMapping("/edit")
	public ModelAndView showUser(@RequestParam("id") int id, ModelMap model) {
		User user = userService.getUserById(id);
		model.put("user", user);
		return new ModelAndView("edit");
	}
	
	@PostMapping("/edit")
	public String saveUser(@RequestParam("id") int id, @RequestParam("name") String name) {
		User user = userService.getUserById(id);
		user.setName(name);
		userService.modifyUser(user);
		return "redirect:/view/" + id;
	}
}
