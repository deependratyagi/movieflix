package com.egen.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egen.beans.MovieList;
import com.egen.service.MovieService;
import com.egen.service.UserService;
import com.egen.service.UserServiceImpl;

@Controller
public class MovieController {

	@Autowired
	private UserService us;
	
	@Autowired
	private MovieService ms;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(ModelMap map,HttpServletRequest req)
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = us.checkLoginCredentials(username,password);
		if(status)
		{
			List<MovieList> movieList = ms.getAllTitle();
			map.put("movies", movieList);
			return "welcome";	
		}
		return "failure";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout()
	{
		return "Login";
	}
	
}
