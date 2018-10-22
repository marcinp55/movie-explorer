package com.movies.explorer.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.movies.explorer.domain.movie.LatestMovieDto;
import com.movies.explorer.domain.movie.MovieDto;

@Component
public class TheMovieDbClient {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${themoviedb.endpoint}")
	private String theMovieDbEndpoint;
	
	@Value("${themoviedb.api.key}")
	private String theMovieDbApiKey;
	
	public MovieDto getMovieById(int id) {
		URI url = UriComponentsBuilder.fromHttpUrl(theMovieDbEndpoint + "/movie/" + Integer.toString(id))
				.queryParam("api_key", theMovieDbApiKey).build().encode().toUri();
		return restTemplate.getForObject(url, MovieDto.class);
	}
	
	public LatestMovieDto getLatestMovie() {
		URI url = UriComponentsBuilder.fromHttpUrl(theMovieDbEndpoint + "/movie/latest")
				.queryParam("api_key", theMovieDbApiKey).build().encode().toUri();
		return restTemplate.getForObject(url, LatestMovieDto.class);
	}
}
