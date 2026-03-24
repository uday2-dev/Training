package com.coforge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.entites.Movie;
import com.coforge.repoistry.MovieRepoistry;

@Repository
public class MovieDao { 
	@Autowired
	MovieRepoistry movieRepoistry;
	
	public List<Movie> getAllMovies1(){
		return movieRepoistry.findAll();
	}
	public Movie addMovie(Movie movie)
	{
		return movieRepoistry.save(movie);
	}
	public Optional<Movie> getByMovieId(Long movieid)
	{
		return  movieRepoistry.findById(movieid);
	}
	public List<Movie> findByLanguage(String language)
	{
		return movieRepoistry.findByLanguage(language);
	}


}
