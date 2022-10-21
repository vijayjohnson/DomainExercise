package com.interview.domainexercise.ticketbookingservice.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Theatre {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String theatreName;
	@ManyToMany(mappedBy="theatres")
	@JsonIgnore
	private Set<Movie> movies;
	private Integer cityId;
	@OneToMany(mappedBy="theatre")
	private Set<Show> shows;
	public Theatre() {
		
	}

	public Integer getTheatre_Id() {
		return id;
	}

	

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Set getMovies() {
		return movies;
	}

	public void setMovies(Set movies) {
		this.movies = movies;
	}

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", theatreName=" + theatreName + ", movies=" + movies + "]";
	}

	


	
	
	
	

}
