package com.task.controller;

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

import com.task.dao.TaskDAO;
import com.task.dao.UserDAO;
import com.task.entity.Task;
import com.task.entity.User;
import com.task.exceptions.*;

@RestController
public class TaskController {
	
	@Autowired
	private UserDAO userDAO; 
	
	@Autowired
	private TaskDAO taskDAO;
	
	@GetMapping("/register")
	public ModelAndView showRegisterForm() {
		return new ModelAndView("register");
	}
	
	@PostMapping("/login")
	public ModelAndView saveUser(@RequestParam("name") String name,
								 @RequestParam("email") String email,
								 @RequestParam("password") String password) {
		User user = new User(email, name, password);
		userDAO.save(user);
		return new ModelAndView("login");
	}
	
	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}
	
	
	@PostMapping("/add")
	public ModelAndView loginUser(@RequestParam("email") String email,
								  @RequestParam("password") String password) {
		if(userDAO.findById(email).get().getPassword().equals(password)) {
			return new ModelAndView("add");
		} 
		return new ModelAndView("login");
	}
	
	@GetMapping("/add")
	public ModelAndView showTaskForm() {
		return new ModelAndView("add");
	}	
	
	@GetMapping("/display")
	public ModelAndView showDisplayForm() {
		return new ModelAndView("display");
	}	
	
	@PostMapping("/display")
	public ModelAndView createTask(@RequestParam("name") String name,
								   @RequestParam("start") String start,
								   @RequestParam("end") String end,
								   @RequestParam("description") String description,
								   @RequestParam("email") String email,
								   @RequestParam("severity") String severity,
								   HttpServletRequest request) {
		Task task = new Task(name, start, end, description, email, severity);
		taskDAO.save(task);
		List<Task> tasks = (List<Task>)taskDAO.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("tasks", tasks);
		return new ModelAndView("display");
	
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showTask(@PathVariable("id")int id, HttpServletRequest request) {
		try {
			Task task = taskDAO.findById(id).get();
			if(task == null) {
				throw new InvalidOptionException("Edit Task ID#" + id + "does not exist");
			}
			return new ModelAndView("/edit").addObject("task", task);
		} catch(InvalidOptionException e) {
			return new ModelAndView("login");
		}
	}
	
	@PostMapping("/edit/{id}")
	public ModelAndView updateTask(@PathVariable("id") int id, 
								 @RequestParam("name") String name,
								 @RequestParam("start") String start,
								 @RequestParam("end") String end,
								 @RequestParam("description") String description,
								 @RequestParam("email") String email,
								 @RequestParam("severity") String severity,
								 HttpServletRequest request) {
		taskDAO.findById(id).get().setName(name);
		taskDAO.findById(id).get().setStart(start);
		taskDAO.findById(id).get().setEnd(end);
		taskDAO.findById(id).get().setDescription(description);
		taskDAO.findById(id).get().setEmail(email);
		taskDAO.findById(id).get().setSeverity(severity);
		List<Task> tasks = (List<Task>)taskDAO.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("tasks", tasks);
		return new ModelAndView("display");
	}
	
	@PostMapping("/delete/{id}")
	public ModelAndView deleteTask(@PathVariable("id") int id,
							       HttpServletRequest request) {
		try {
			taskDAO.deleteById(id);
			if(taskDAO.existsById(id)) {
				throw new FailedDeleteException("Delete Task ID#" + id + "failed");
			}
			List<Task> tasks = (List<Task>)taskDAO.findAll();
			HttpSession session = request.getSession();
			session.setAttribute("tasks", tasks);
			return new ModelAndView("display");
		} catch(FailedDeleteException e) {
			return new ModelAndView("login");
		}
	}
}
