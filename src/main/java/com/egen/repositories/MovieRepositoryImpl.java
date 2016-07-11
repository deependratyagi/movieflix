package com.egen.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egen.beans.MovieList;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public MovieList setAvgRating(String titleId, String rating) {
		MovieList ml = em.find(MovieList.class, titleId);
		if(ml!=null)
		{
			ml.setList_avgrating(rating);
			em.merge(ml);
			return ml;
		}
		return null;
	}

	@Override
	public String getAvgRating(String titleId) {
		MovieList ml = em.find(MovieList.class, titleId);
		if(ml!=null)
		{
			return ml.getList_avgrating();
		}
		return null;
	}

	@Override
	public int getCountUsers(String titleId) {
		MovieList ml = em.find(MovieList.class, titleId);
		if(ml!=null)
		{
			return ml.getList_countusers();
		}
		return 0;
	}
	
	public void setCountusers(String titleId,int count)
	{
		MovieList ml = em.find(MovieList.class, titleId);
		if(ml!=null)
		{
			ml.setList_countusers(count);
			em.merge(ml);
		}
	}

}
