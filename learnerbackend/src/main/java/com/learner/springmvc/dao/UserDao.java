package com.learner.springmvc.dao;

import java.util.List;
import com.learner.springmvc.model.User;

public interface UserDao {
	User findById(Long id);
	
	void saveUser(User user);
	
	void deleteUserByEmail(String email);
	
	List<User> findAllUsers();
	
	User findUserByEmail(String email);
}
