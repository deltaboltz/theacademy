package com.learner.springmvc.manager;

import java.util.List;

import com.learner.springmvc.model.UserView;

public interface UserManager {
	
	UserView findById(long id);
	
	void saveUser(UserView user);
	
	void updateUser(UserView user);
	
	void deleteUserByEmail(String email);
	
	List<UserView> findAllUsers();
	
	UserView findUserByEmail(String email);
	
}
