package com.egen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.beans.MovieList;
import com.egen.beans.User;
import com.egen.service.MovieService;
import com.egen.service.UserService;

@RestController
public class RestMovieFlix {

	@Autowired
	private UserService us;
	
	@Autowired
	private MovieService ms;
	
	@RequestMapping(value="/createUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user)
	{
	  User u = us.createUser(user); 
	  return u;
	}
	
	@RequestMapping(value="/ratetitle/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public MovieList rateTitle(@PathVariable("id") String titleId,@RequestBody String rating)
	{
		MovieList ml = ms.setAvgRating(titleId, rating);
		return ml;
	}
	
	@RequestMapping(value="/editTitle/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public MovieList editTitle(@PathVariable("id") String titleId,@RequestBody MovieList movie)
	{
		MovieList m = ms.editTitle(titleId, movie);
		return m;
	}
	
	@RequestMapping(value="/addTitle",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public MovieList addTitle(@RequestBody MovieList movie)
	{
		MovieList m = ms.addTitle(movie);
		return m;
	}
	
	@RequestMapping(value="/deleteTitle/{id}",method=RequestMethod.DELETE)
	public void deleteTitle(@PathVariable("id") String titleId)
	{
		ms.deleteTitle(titleId);
	}
	
	@RequestMapping(value="/getTitle/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public MovieList getTitle(@PathVariable("id") String titleId)
	{
		MovieList m = ms.getTitle(titleId);
		return m;
	}
}
