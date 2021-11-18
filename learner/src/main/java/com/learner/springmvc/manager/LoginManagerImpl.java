//package com.learner.springmvc.manager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.learner.springmvc.dao.UserDao;
//import com.learner.springmvc.model.UserView;
//
//@Service("loginService")
//@Transactional
//public class LoginManagerImpl implements LoginManager{
//
//	@Autowired
//	private UserDao dao;
//	
//	
//	public UserView findUserByEmail(String email) {
//		return dao.findUserByEmail(email);
//	}
//
//	public boolean doesEmailPasswordMatch(String email, String password) {
//		UserView user = findUserByEmail(email);
//		
//		return(user.getPassword().equals(password) && (user.getEmail().equals(email)));
//	}
//
//	public UserView findById(long id) {
//		return dao.findById(id);
//	}
//	
//	public String getNameByEmail(String email) {
//		UserView user = findUserByEmail(email);
//		
//		return user.getName();
//		
//	}
//
//}
