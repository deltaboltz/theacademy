package com.learner.springmvc.service;


import com.learner.springmvc.model.User;

public interface LoginService {
	User findById(long id);
	
	User findUserByEmail(String email);
	
	boolean doesEmailPasswordMatch(String email, String password);
	
	String getNameByEmail(String email);
}
