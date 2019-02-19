package com.example.todolist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.todolist.model.User;
import com.example.todolist.service.UserService;;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String getUserList(Model model) {
		System.out.println("MODEL" + model);
		try {
			List<User> user = userService.getUserList( );
			model.addAttribute("User", user);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return "users";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("User", new User());
		return "add";
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("User") User newUser, BindingResult result) {
		User user = new User();
		user.setId(newUser.getId());
		user.setName(newUser.getName());
		user.setPassword(newUser.getPassword());
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value = "/deleteUser/{id}",  method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id) {
		User user = userService.getUser(id);
		userService.deleteUser(user);
        return "redirect:/users";
	}
	
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
	public String editUser(@PathVariable Integer id, User u) {
	 	User user = userService.getUser(id);
	 	user.setName(u.getName());
	 	user.setPassword(u.getPassword());
	 	userService.updateUser(user);
		return "redirect:/index/";
	} 
	

}
