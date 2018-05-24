/**
 * 
 */
package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nihal
 *
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController{

	@RequestMapping("/login")	
	protected ModelAndView handleLogin(){
		
		ModelAndView modelAndView= new ModelAndView("loginPage");
		modelAndView.addObject("welcomeMessage","Hi User, Please login into the application");
		return modelAndView;
		
	}
	
	@RequestMapping("/logout")
	protected ModelAndView handleLogout(){
		
		ModelAndView modelAndView= new ModelAndView("loginPage");
		modelAndView.addObject("welcomeMessage","Hi User, You are logout..\nPlease login again to enter into application");
		return modelAndView;
		
	}

	@RequestMapping(value="/verifyUser", method=RequestMethod.POST)
	protected ModelAndView authenticateUserLogin(@RequestParam("userName") String userName, @RequestParam(value="selectRole", defaultValue="Admin") String role) {
		
		ModelAndView modelAndView= new ModelAndView();
		
		if("admin".equalsIgnoreCase(role))
			modelAndView.setViewName("adminLoginPage");
		else if("teacher".equalsIgnoreCase(role))
			modelAndView.setViewName("teacherLoginPage");
		else if("student".equalsIgnoreCase(role))
			modelAndView.setViewName("studentLoginPage");
		else if("parent".equalsIgnoreCase(role))
				modelAndView.setViewName("parentLoginPage");
		modelAndView.addObject("welcomeMessage",role+" Login !!!");
		modelAndView.addObject("userName",userName);
		return modelAndView;
		
	}
}
