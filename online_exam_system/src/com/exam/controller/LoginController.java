package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.service.AuthService;



@Controller
@RequestMapping("/user")
public class LoginController {
	
	private AuthService authenticateService;	
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)

	public ModelAndView validateUsr(@RequestParam("email")String username,@RequestParam("password")String password) {
		String msg = "";
		boolean isValid = authenticateService.findUser(username, password);
		

		if(isValid) {
			msg = "Welcome " + username + "!";
		} else {
			msg = "Invalid credentials";
		}

		return new ModelAndView("user", "userName", msg);
	}
}

	

