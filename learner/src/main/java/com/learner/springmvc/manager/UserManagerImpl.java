package com.learner.springmvc.manager;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.learner.springmvc.model.UserView;

@Service("userService")
@Transactional
public class UserManagerImpl implements UserManager {
	
	private final String RESTURL = "http://localhost:8080/learnerbackend/user/";

	@Autowired
	private RestTemplate restTemplate;
	
	public UserView findById(long id) {
		String requestUri = RESTURL + "findbyid/{id}";
		Map<String, String> params = new HashMap<>();
		params.put("id", Long.toString(id));
		
		return restTemplate.getForObject(requestUri, UserView.class, params);
	}
	
	public void saveUser(UserView user) {
		String requestUri = RESTURL + "saveuser";
		restTemplate.postForObject(requestUri, user, UserView.class);
	}
	
	public void updateUser(UserView user) {
		String requestUri = RESTURL + "updateuser";
		restTemplate.put(requestUri, user);
	}
	
	public void deleteUserByEmail(String email) {
		String requestUri = RESTURL + "deleteuserbyemail/{email}-delete";
		Map<String, String> params = new HashMap<>();
		params.put("email", email);
		
		restTemplate.delete(requestUri, params);
	}
	
	public List<UserView> findAllUsers(){
		String requestUri = RESTURL + "findallusers";
		UserView[] response = restTemplate.getForObject(requestUri, UserView[].class);
		List<UserView> users = new ArrayList<>();
		for(UserView user: response) {
			users.add(user);
		}
		return users;
	}
	
	public UserView findUserByEmail(String email) {
		String requestUri = RESTURL + "finduserbyemail/{email}-user";
		Map<String, String> params = new HashMap<>();
		params.put("email", email);
		UserView user = restTemplate.getForObject(requestUri, UserView.class, params);
		return user;
	}
}
