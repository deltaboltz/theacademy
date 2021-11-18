package com.learner.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learner.springmvc.manager.UserManager;
import com.learner.springmvc.model.UserView;

@Controller
public class UserController{
	
	@Autowired
	UserManager manager;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = {"/user", "/list"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<UserView> users = manager.findAllUsers();
		model.addAttribute("users", users);
		return "allusers";
	}
	
	@RequestMapping(value= {"/user/new"}, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		UserView user = new UserView();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	@RequestMapping(value = { "/user/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid UserView user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
         
        manager.saveUser(user);
 
        model.addAttribute("success", "User " + user.getName() + " registered successfully");
        return "success";
    }
	
	@RequestMapping(value= {"/user/edit-{email}-user"}, method = RequestMethod.GET)
	public String editUser(@PathVariable String email, ModelMap model) {
		UserView user = manager.findUserByEmail(email);
		System.out.println(user);
		model.addAttribute("user",user);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	@RequestMapping(value= {"/user/edit-{email}-user"}, method=RequestMethod.POST)
	public String updateUser(@Valid UserView user, ModelMap model, @PathVariable String email) {
		
		manager.updateUser(user);
		
		model.addAttribute("success", "User " + user.getName() + " updated successfully");
		
		return "success";
	}
	
	@RequestMapping(value = { "/user/delete-{email}-user" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String email) {
        manager.deleteUserByEmail(email);
        return "redirect:/list";
    }
}