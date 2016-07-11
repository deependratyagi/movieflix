package com.egen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.beans.MovieList;
import com.egen.customexceptions.MovieException;
import com.egen.repositories.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository mr;
	
	@Override
	public MovieList setAvgRating(String titleId, String rating) {
		String preRating = getAvgRating(titleId);
		if(preRating==null)
		{
			preRating = "0.0";
		}
		
		Double ratingDouble = Double.parseDouble(preRating);
		int count = getCountUsers(titleId);
		count = count+1;
		double sum = ratingDouble*count;
		System.out.println("&&&&&&&&&&&&&&&&&&"+rating);
		sum = sum+Integer.parseInt(rating.trim());
		System.out.println("sum:"+sum+" count:"+count);
		ratingDouble = (sum)/count;
		MovieList ml = mr.setAvgRating(titleId, ratingDouble.toString());
		if(ml!=null){
		setCountusers(titleId, count);
		return ml;
		}
		else{
			throw new MovieException("Title not found");
		}
		
	}

	@Override
	public String getAvgRating(String titleId) {
		String rating = mr.getAvgRating(titleId);
		return rating;
	}

	@Override
	public int getCountUsers(String titleId) {
		int count = mr.getCountUsers(titleId);
		return count;
	}
	
	public void setCountusers(String titleId,int count)
	{
		mr.setCountusers(titleId, count);
	}

}
