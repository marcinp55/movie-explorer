package com.movies.explorer.domain.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestMovieDto {
	private String title;
	private String original_language;
	private boolean adult;
	private int budget;
}
