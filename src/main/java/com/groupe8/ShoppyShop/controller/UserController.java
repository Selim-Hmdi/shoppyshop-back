package com.groupe8.ShoppyShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupe8.ShoppyShop.model.User;
import com.groupe8.ShoppyShop.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable(name = "id") Integer id) {
		User user = service.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<User> findUserByEmail(@PathVariable(name = "email") String email) {
		User user =  service.findByEmail(email);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user/{email}/{password}")
	public ResponseEntity<User> findUserByEmailAndPassword(@PathVariable(name = "email") String email, @PathVariable(name = "password") String password) {
		User user = service.findByEmailAndPassword(email, password);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		return service.save(user);
	}
}
