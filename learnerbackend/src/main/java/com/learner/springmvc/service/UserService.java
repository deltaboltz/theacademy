package com.learner.springmvc.service;

import java.util.List;

import com.learner.springmvc.model.User;

public interface UserService {
	
	User findById(Long id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByEmail(String email);
	
	List<User> findAllUsers();
	
	User findUserByEmail(String email);
	
	boolean isUserEmailUnique(Long id, String email);
}
