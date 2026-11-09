package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(path = "sayhello", method = RequestMethod.GET)
	public ModelAndView showHelloMessage() {
		
		String message = "All the Best for learning Spring Platform!";
		
		System.out.println("Inside controller!");
		
		// view page name, data param name, data to be rendered on UI
		return new ModelAndView("hello", "myMessage", message); 
	}

}
