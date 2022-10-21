package com.interview.domainexercise.ticketbookingservice.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Movie {
	@Id
	@GeneratedValue
	private Integer id;
	private String movieName;
	private String genre;
	private String language;
	@ManyToMany
	@JoinTable(
			name="movie_play_theatre",
			joinColumns=@JoinColumn(name="movie_Id"),
			inverseJoinColumns=@JoinColumn(name="theatre_Id"))
	private Set<Theatre> theatres;
	

	
	public Movie() {
		
	}
	
	public Integer getMovie_Id() {
		return id;
	}

	

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	

	

	public Set getTheatres() {
		return theatres;
	}

	public void setTheatres(Set theatres) {
		this.theatres = theatres;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", genre=" + genre + ", language=" + language
				+ ", theatres=" + theatres + "]";
	}

	

	

	
	
	
	
	

}
