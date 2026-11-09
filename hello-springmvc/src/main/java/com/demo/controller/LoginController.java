package com.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoginForm;

@Controller
public class LoginController {
	
	@RequestMapping(path = "userlogin", method = RequestMethod.GET)
	public String loadLoginForm(Map model) {
		
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		
		return "login";
		
	}
	
	@RequestMapping(path = "userlogin", method = RequestMethod.POST)
	public ModelAndView processLoginForm(@Valid LoginForm loginForm, BindingResult result) {
		
		System.out.println(loginForm.getUsername());
		System.out.println(loginForm.getPassword());
		
		if(result.hasErrors()) {
			ModelAndView modelAndViewValidation = new ModelAndView("login");
			modelAndViewValidation.addObject("validationMessage", "There are some validation errors in your fields...");
			
			return modelAndViewValidation;
		}
		
		if(loginForm.getUsername().equals("Admin") && loginForm.getPassword().equals("admin1234")) {
			ModelAndView modelAndViewWelcome = new ModelAndView("welcome");
			modelAndViewWelcome.addObject("welcomeMessage", "Hi! Welcome to Spring MVC!");
			return modelAndViewWelcome;
		} else if(!loginForm.getUsername().equals("Admin")){
			ModelAndView modelAndViewError = new ModelAndView("error");
			modelAndViewError.addObject("errorMessage", "Invalid credentials!");
			return modelAndViewError;
		}
		
		return new ModelAndView("login");
	}

}
