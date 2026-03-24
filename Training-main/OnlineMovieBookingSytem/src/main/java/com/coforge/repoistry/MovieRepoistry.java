package com.coforge.repoistry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.coforge.entites.Movie;

public interface MovieRepoistry extends JpaRepository<Movie, Long>{
	public List<Movie> findByLanguage(@Param("language") String language);
	public Movie findByTitle(@Param("title") String title);
	public List<Movie> findByPrice(@Param("price")double price);

	
	
}
