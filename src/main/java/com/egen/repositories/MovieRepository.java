package com.egen.repositories;

import org.springframework.stereotype.Repository;

import com.egen.beans.MovieList;

@Repository
public interface MovieRepository {

	public MovieList setAvgRating(String titleId,String rating);
	public String getAvgRating(String titleId); 
	public int getCountUsers(String titleId);
	public void setCountusers(String titleId,int count);
}