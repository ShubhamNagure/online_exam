package com.exam.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.User;
import com.exam.service.NewRegisterService;



@Controller
public class HomeController {
	@Autowired
	private NewRegisterService NewRegisterService;

	
	public NewRegisterService getNewRegisterService() {
		return NewRegisterService;
	}

	public void setNewRegisterService(NewRegisterService newRegisterService) {
		NewRegisterService = newRegisterService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("Home Page Requested");
		return "home";
	}

	@RequestMapping(value ="/user" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("User", new User());
		return "user";
	}
	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.GET)
	public ModelAndView registerSuccess( @ModelAttribute("user") User user){
		
		getNewRegisterService().registerUser(user);
		ModelAndView modelAndView = new ModelAndView("user");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	/*@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		
		model.addAttribute("userName", user.getUserName());
		return "user";
	}*/
}
