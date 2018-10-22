package com.movies.explorer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.explorer.client.TheMovieDbClient;
import com.movies.explorer.domain.movie.LatestMovieDto;
import com.movies.explorer.domain.movie.MovieDto;

@RestController
@CrossOrigin("*")
@RequestMapping("movies/")
public class MoviesController {
	@Autowired
	private TheMovieDbClient movieDbClient;
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public MovieDto getMovieById(@PathVariable int id) {
		return movieDbClient.getMovieById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "latest")
	public LatestMovieDto getLatestMovie() {
		return movieDbClient.getLatestMovie();
	}
}
