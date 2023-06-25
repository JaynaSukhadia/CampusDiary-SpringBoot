package com.aurosoft.campusdiary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.campusdiary.entity.User;
import com.aurosoft.campusdiary.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	UserRepository repository;
	@Autowired
	public UserController(UserRepository userRepository) {
		this.repository=userRepository;
	}
	
	@GetMapping("/list")
	public String listuser (Model m) {
		List<User> list=repository.findAll();
		m.addAttribute("list", list);
		return "user_list";
	}
	
	@GetMapping("/newuser")
	public String showform(User user)
	{
		return "user_entry";
	}
	
	@PostMapping("/insert")
	public String insertUser(@ModelAttribute("user") User user) {
		repository.save(user);
		return "redirect:/user/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editUser(@PathVariable int id, Model m)
	{
		Optional <User>user=repository.findById(id);
		User us = null;
		if(user.isPresent())
			us = user.get();
		
		m.addAttribute("user", us);
		return "user_edit";
			
	}
	
	@PostMapping(value="/update")
	public String updateUser(@ModelAttribute("user") User user)
	{
		repository.save(user);
		return "redirect:/user/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteUser(@PathVariable int id,Model m) 
	{
		repository.deleteById(id);
		return "redirect:/user/list";
	}

}
