package com.egen.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egen.service.UserService;
import com.egen.service.UserServiceImpl;

@Controller
public class MovieController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(ModelMap map,HttpServletRequest req)
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = us.checkLoginCredentials(username,password);
		if(status)
		{
			return "login";	
		}
		return "failure";
	}
	
}
