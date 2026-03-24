package com.coforge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.dao.MovieDao;
import com.coforge.entites.Booking;
import com.coforge.entites.Movie;
import com.coforge.repoistry.BookingRepositry;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;
	
	public List<Movie> getAllMovies1(){
		return movieDao.getAllMovies1();
	}
	public Movie addMovie(Movie movie)
	{
		return movieDao.addMovie(movie);
	}
	public Movie getByMovieId(Long movieid)
	{
		return  movieDao.getByMovieId(movieid).orElseThrow(()->new RuntimeException());
	}
	public List<Movie> findByLanguage(String language)
	{
		return movieDao.findByLanguage(language);
	}


}
