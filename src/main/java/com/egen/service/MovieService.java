package com.egen.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.egen.beans.MovieList;

@Service
public interface MovieService{
public MovieList setAvgRating(String titleId,String rating);
public String getAvgRating(String titleId); 
public int getCountUsers(String titleId);
public void setCountusers(String titleId,int count);
public MovieList editTitle(String titleId,MovieList movie);
public MovieList addTitle(MovieList movie);
public void deleteTitle(String titleId);
public MovieList getTitle(String titleId);
public List<MovieList> getAllTitle();
}
