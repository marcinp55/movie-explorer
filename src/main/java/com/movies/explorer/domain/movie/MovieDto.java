package com.movies.explorer.domain.movie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movies.explorer.domain.LanguageDto;
import com.movies.explorer.domain.company.ProductionCompanyDto;
import com.movies.explorer.domain.country.ProductionCountryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
	private boolean adult;
	private boolean video;
	private int budget;
	private int id;
	private int revenue;
	private int runtime;
	private int popularity;
	private String status;
	private String tagline;
	private String title;
	private String overview;
	private List<GenreDto> genres;
	
	@JsonProperty("backdrop_path")
	private String backdropPath;
	
	@JsonProperty("imdb_id")
	private String imdbId;
	
	@JsonProperty("original_title")
	private String originalTitle;
	
	@JsonProperty("homepage")
	private String homePage;
	
	@JsonProperty("release_date")
	private String releaseDate;
	
	@JsonProperty("vote_average")
	private int voteAverage;
	
	@JsonProperty("vote_count")
	private int voteCount;
	
	@JsonProperty("original_language")
	private String originalLanguage;
	
	@JsonProperty("poster_path")
	private String posterPath;
	
	@JsonProperty("spoken_languages")
	private List<LanguageDto> spokenLanguages;
	
	@JsonProperty("production_companies")
	private List<ProductionCompanyDto> productionCompanies;
	
	@JsonProperty("production_countries")
	private List<ProductionCountryDto> productionCountries;
}
