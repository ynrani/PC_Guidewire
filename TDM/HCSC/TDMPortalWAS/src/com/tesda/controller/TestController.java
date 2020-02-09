package com.tesda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.model.DTO.Users;

 

@Controller
public class TestController {

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public ModelAndView printWelcome(@ModelAttribute("user") Users user) {

		ModelAndView mav = new ModelAndView("lazyRowLoad");
		mav.addObject("message", "Hello World!!!");
		return mav;

	}

	@RequestMapping(value = "/lazyRowAdd", method = RequestMethod.POST)
	public ModelAndView lazyRowAdd(@ModelAttribute("user") Users user) {

		Users users=new Users();
		ModelAndView mav = new ModelAndView("lazyRowLoad");
		mav.addObject("users", users);
		return mav;

	}

}
