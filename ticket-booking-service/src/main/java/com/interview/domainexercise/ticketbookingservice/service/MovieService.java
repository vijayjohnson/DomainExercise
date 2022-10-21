package com.interview.domainexercise.ticketbookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interview.domainexercise.ticketbookingservice.entity.Movie;
import com.interview.domainexercise.ticketbookingservice.repositories.MovieRepository;
@Component
public class MovieService {
	
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	public Movie addNewMovie(Movie movie) {
		
		return movieRepository.save(movie);
		
	}
	
	public List<Movie> getAllMovies(){
		
		return movieRepository.findAll();
	}
	
	public Optional<Movie> getMovieById(Integer id) {
		
		return movieRepository.findById(id);
	}

}
