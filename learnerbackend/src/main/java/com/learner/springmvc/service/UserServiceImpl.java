package com.learner.springmvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learner.springmvc.dao.UserDao;
import com.learner.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	public User findById(Long id) {
		return dao.findById(id);
	}
	
	public void saveUser(User user) {
		dao.saveUser(user);
	}
	
	public void updateUser(User user) {
		User entity = dao.findUserByEmail(user.getEmail());
		//entity.setId(user.getId());
		if(entity != null) {
			entity.setName(user.getName());
			entity.setPassword(user.getPassword());
			entity.setEmail(user.getEmail());
		}
		//Entity is null
	}
	
	public void deleteUserByEmail(String email) {
		dao.deleteUserByEmail(email);
	}
	
	public List<User> findAllUsers(){
		return dao.findAllUsers();
	}
	
	public User findUserByEmail(String email) {
		return dao.findUserByEmail(email);
	}
	
	public boolean isUserEmailUnique(Long id, String email) {
		User user = findUserByEmail(email);
		
		return(user == null || ((id != null ) && (user.getId()== id)));
	}
}
