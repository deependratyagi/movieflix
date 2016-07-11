package com.egen.service;

import java.util.List;

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
		
		sum = sum+Integer.parseInt(rating.trim());
		
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

	@Override
	public MovieList editTitle(String titleId, MovieList movie) {
		movie = mr.editTitle(titleId, movie);
		if(movie!=null){
		return movie;
		}else{
			throw new MovieException("Movie title not found.");
		}
		
	}

	@Override
	public MovieList addTitle(MovieList movie) {
		MovieList m = mr.addTitle(movie);
		if(m!=null)
		{
			return m;
		}
		else{
			throw new MovieException("Movie title already exist.");
		}
	}

	@Override
	public void deleteTitle(String titleId) {
		boolean status = mr.deleteTitle(titleId);
		if(!status)
		{
			throw new MovieException("Movie not found.");
		}
	}

	@Override
	public MovieList getTitle(String titleId) {
		
		MovieList m = mr.getTitle(titleId);
		if(m!=null)
		{
		  return m;
		}else{
			throw new MovieException("Movie not found.");
		}
	}

	@Override
	public List<MovieList> getAllTitle() {
		List<MovieList> list = mr.getAllTitle();
		return list;
	}
	
	

}
