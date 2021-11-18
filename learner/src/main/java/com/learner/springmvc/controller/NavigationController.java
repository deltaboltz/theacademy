package com.learner.springmvc.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.learner.springmvc.manager.LoginManager;
import com.learner.springmvc.model.UserView;

@Controller
public class NavigationController {

	
//	@Autowired
//	LoginManager service;
	
	@Autowired
	MessageSource messageSource;

	// Navigates to the joinus signup page
	@RequestMapping(value = { "/joinus" }, method = RequestMethod.GET)
	public String navigateToSignup() {
		return "UserSignup";
	}

	// Navigates back to the home page
	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public String navigateToHome() {
		
		return "index";
	}

	// Navigates to the account page
//	@RequestMapping(value = "/account", method = RequestMethod.GET)
//	public ModelAndView navigateToAccount() {
//		ModelAndView mv = new ModelAndView();
//		JSONParser jsonparser = new JSONParser();
//
//		// Set string variables to full local scope so we can return these objects to
//		// the account page
//		String email = null;
//		String name = null;
//		String date = null;
//		try {
//			// Open, parse, and read the json file
//			JSONObject jsonobj = null;
//			try {
//				jsonobj = (JSONObject) jsonparser.parse(new FileReader(
//						"C:\\Users\\connor.schultz\\eclipse\\workspace\\personal\\TheAcademy1\\learner\\src\\main\\java\\com\\learner\\springmvc\\outputs\\userlogin.json"));
//			} catch (org.json.simple.parser.ParseException e) {
//				e.printStackTrace();
//			}
//			email = (String) jsonobj.get("useremail");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		UserView u1 = service.findUserByEmail(email);
//		System.out.println(email);
//		
//		name = u1.getName();
//		
//		// Add the objects to the view that we will return
//		mv.addObject("email", email);
//		mv.addObject("userfname", name);
//
//		mv.setViewName("AccountPage");
//
//		return mv;
//		}

	// Navigates to the CourseRequest page
	@RequestMapping(value = "/courserequest", method = RequestMethod.GET)
	public ModelAndView navigateToRequest() {
		ModelAndView mv = new ModelAndView();
		JSONParser jsonparser = new JSONParser();
		String fname = null;

		// Pull the json data that we just gained in order to have the name pop up on
		// the course request page no matter what
		try {
			JSONObject jsonobj = null;
			try {
				jsonobj = (JSONObject) jsonparser.parse(new FileReader(
						"C:\\Users\\connor.schultz\\eclipse\\workspace\\personal\\TheAcademy1\\learner\\src\\main\\java\\com\\learner\\springmvc\\outputs\\output.json"));
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
			fname = (String) jsonobj.get("firstname");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// add the firstname to the page
		mv.addObject("userfname", fname);
		mv.setViewName("CourseRequest");

		return mv;
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String navigateToLogin(Model model) {
		UserView user = new UserView();
		model.addAttribute("user", user);
		return "AccountLogin";
	}
	
//	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
//	public String logInSuccess(@Valid UserView user, BindingResult result,
//            ModelMap model) {
//		
//		if(!service.doesEmailPasswordMatch(user.getEmail(), user.getPassword())){
//            FieldError emailError =new FieldError("user","email",messageSource.getMessage("email.password.nonmatch", new String[]{user.getEmail()}, Locale.getDefault()));
//            result.addError(emailError);
//            return "AccountLogin";
//        }
//		
//		JSONObject jsonobj = new JSONObject();
//		
//		jsonobj.put("useremail", user.getEmail());
//		try
//		{
//			FileWriter file = new FileWriter("C:\\Users\\connor.schultz\\eclipse\\workspace\\personal\\TheAcademy1\\learner\\src\\main\\java\\com\\learner\\springmvc\\outputs\\userlogin.json");
//			file.write(jsonobj.toJSONString());
//			file.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		UserView u1 = service.findUserByEmail(user.getEmail());
//		
//		model.addAttribute("userfname", u1.getName());
//		model.addAttribute("email", u1.getEmail());
//		return "AccountPage";
//		
//	}

}
