package com.egen.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	@Override
	public MovieList editTitle(String titleId, MovieList movie) {
		MovieList m = em.find(MovieList.class,titleId);
		if(m!=null)
		{
			m.setList_title(movie.getList_title());
			em.merge(m);
			return m;
		}
		return null;
	}

	@Override
	public MovieList addTitle(MovieList movie) {
		MovieList m = em.find(MovieList.class,movie.getList_imdbId());
		if(m==null)
		{
			em.persist(movie);
			return movie;
		}
		return null;
	}

	@Override
	public boolean deleteTitle(String titleId) {
		MovieList m = em.find(MovieList.class, titleId);
		if(m!=null)
		{
			em.remove(m);
			return true;
		}
		return false;
	}

	@Override
	public MovieList getTitle(String titleId) {
		MovieList m = em.find(MovieList.class, titleId);
		return m;
	}

	@Override
	public List<MovieList> getAllTitle() {
		TypedQuery<MovieList> query = (TypedQuery<MovieList>)em.createQuery("select m from MovieList m order by m.list_title");
		return query.getResultList();
	}

}
