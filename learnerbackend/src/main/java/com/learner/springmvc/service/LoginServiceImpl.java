package com.learner.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learner.springmvc.dao.UserDao;
import com.learner.springmvc.model.User;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao dao;
	
	
	public User findUserByEmail(String email) {
		return dao.findUserByEmail(email);
	}

	public boolean doesEmailPasswordMatch(String email, String password) {
		User user = findUserByEmail(email);
		
		return(user.getPassword().equals(password) && (user.getEmail().equals(email)));
	}

	public User findById(long id) {
		return dao.findById(id);
	}
	
	public String getNameByEmail(String email) {
		User user = findUserByEmail(email);
		
		return user.getName();
		
	}

}
