package com.challenge.domus.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	//title of the movie
	@JsonProperty("Title")
	private String title;

	//year the movie was released
	@JsonProperty("Year")
	private String year;

	//movie rating
	@JsonProperty("Rated")
	private String rated;

	//movie release date
	@JsonProperty("Released")
	private String released;
	
	//movie duration time in minutes;
	@JsonProperty("Runtime")
	private String runtime;
	
	//movie duration time in minutes
	@JsonProperty("Genre")
	private String genre;

	//movie director
	@JsonProperty("Director")
	private String director;
	
	//movie writers
	@JsonProperty("Writer")
	private String writer;

	//movie actors
	@JsonProperty("Actors")
	private String actors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

}
