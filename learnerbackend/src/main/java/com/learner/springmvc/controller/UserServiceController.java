package com.learner.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learner.springmvc.model.User;
import com.learner.springmvc.service.UserService;

@RestController
public class UserServiceController {

	@Autowired
	UserService service;
	
	@GetMapping(value = "user/findbyid/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id){
		
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		
	}
	
	@PostMapping(value = "user/saveuser")
	public ResponseEntity<Void> saveUser(@RequestBody User user){
		service.saveUser(user);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping(value = "user/updateuser")
	public ResponseEntity<Void> updateUser(@RequestBody User user){
		service.updateUser(user);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value = "user/deleteuserbyemail/{email}-delete")
	public ResponseEntity<Void> deleteUserByEmail(@PathVariable("email") String email){
		service.deleteUserByEmail(email);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="user/findallusers")
	public ResponseEntity<List<User>> findAllUsers(){
		return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value="user/finduserbyemail/{email}-user")
	public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email){
		System.out.println(email);
		System.out.println(service.findUserByEmail(email));
		return new ResponseEntity<>(service.findUserByEmail(email), HttpStatus.OK);
	}
}
