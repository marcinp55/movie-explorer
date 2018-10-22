package com.movies.explorer.domain.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionCompanyDto {
	private String name;
	private int id;
	
	@JsonProperty("logo_path")
	private String logoPath;
	
	@JsonProperty("origin_country")
	private String originCountry;
}
