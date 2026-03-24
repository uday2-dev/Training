package com.coforge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.dao.MovieDao;
import com.coforge.entites.Movie;
import com.coforge.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/")
	public List<Movie> getAllMovies1(){
		return movieService.getAllMovies1();
	}
	
	@PostMapping("/")
	public Movie addMovie(Movie movie)
	{
		return movieService.addMovie(movie);
	}
	@GetMapping("/{movieid}")
	
	public Movie getByMovieId(@PathVariable("movieid") long movieid)
	{
		return  movieService.getByMovieId(movieid);
	}
	
	@GetMapping("/language/{language}")
	public List<Movie> findByLanguage(@PathVariable("language") String language)
	{
		return movieService.findByLanguage(language);
	}
}
