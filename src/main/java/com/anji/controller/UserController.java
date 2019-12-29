package com.anji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.anji.entity.User;
import com.anji.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/login")
	public boolean loginUser(@Valid @RequestBody User user) {
		return userService.loginUser(user);
	}

	@PostMapping("/users/add")
	public User addUser(@Valid @RequestBody User user) {
		return userService.saveOrUpdateUser(user);
	}
	
	@GetMapping("/users/{Id}")
	public User getUserById(@PathVariable("Id") Long id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/users/delete/{Id}")
	public void deleteUser(@PathVariable("Id") Long id) {
		userService.deleteUser(id);
	}

}
