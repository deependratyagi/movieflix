package com.egen.service;

import org.springframework.stereotype.Service;

import com.egen.beans.MovieList;

@Service
public interface MovieService{
public MovieList setAvgRating(String titleId,String rating);
public String getAvgRating(String titleId); 
public int getCountUsers(String titleId);
public void setCountusers(String titleId,int count);
}
