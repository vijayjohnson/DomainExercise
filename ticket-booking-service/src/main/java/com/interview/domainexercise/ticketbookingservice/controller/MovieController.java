package com.interview.domainexercise.ticketbookingservice.controller;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interview.domainexercise.ticketbookingservice.entity.Movie;
import com.interview.domainexercise.ticketbookingservice.entity.Show;
import com.interview.domainexercise.ticketbookingservice.entity.Theatre;
import com.interview.domainexercise.ticketbookingservice.exception.MovieNotFoundException;
import com.interview.domainexercise.ticketbookingservice.exception.TheatreNotFoundException;
import com.interview.domainexercise.ticketbookingservice.service.MovieService;
import com.interview.domainexercise.ticketbookingservice.service.ShowService;
import com.interview.domainexercise.ticketbookingservice.service.TheatreService;

@RestController
public class MovieController {
	
	private MovieService movieService;
	private TheatreService theatreService;
	private ShowService showService;
	
	public MovieController(MovieService movieService, TheatreService theatreService,
								ShowService showService) {
		
		this.movieService=movieService;
		this.theatreService=theatreService;
		this.showService=showService;
	}
	
	@PostMapping("movies")
	public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
		
		Movie addedMovie= movieService.addNewMovie(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addedMovie.getMovie_Id()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("movies")
	public List<Movie> getAllMovies(){
		
		return movieService.getAllMovies();
	}
	
	@GetMapping("movies/{id}")
	public Movie getMovieById(@PathVariable Integer id) {
		
		Optional<Movie> movie= movieService.getMovieById(id);
		if(movie.isEmpty()) {
			throw new MovieNotFoundException("Movie Not Found with id "+ id);
		}
		return movie.get();
	}
	
	@PostMapping("movies/{id}/theatres")
	public ResponseEntity addTheatresToMovie(@PathVariable Integer id, @RequestBody Theatre theatre) {
		
		Set<Movie> movies = new HashSet<Movie>();
		
		Optional<Movie> movie= movieService.getMovieById(id);
		
		if(movie.isEmpty()) {
			throw new MovieNotFoundException("Movie Not Found with id "+ id);
		}
		movies.add(movie.get());
		theatre.setMovies(movies);
		Theatre addedTheatre = theatreService.addNewTheatre(theatre);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addedTheatre.getTheatre_Id()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping("theatres/{id}/movies")
	public ResponseEntity addMoviesToTheatre(@PathVariable Integer id, @RequestBody Movie movie) {
		Set<Theatre> theatres = new HashSet<Theatre>();
		Optional<Theatre> theatre = theatreService.getTheatreById(id);
		if(theatre.isEmpty()) {
			throw new TheatreNotFoundException("Theatre not found with id "+ id);
		}
		
		theatres.add(theatre.get());
		movie.setTheatres(theatres);
		Movie addedMovie =movieService.addNewMovie(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addedMovie.getMovie_Id()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping("theatres/{id}/shows")
	public ResponseEntity addShowstoTheatre(@PathVariable Integer id, @RequestBody Show show) {
		
		Optional<Theatre> theatre = theatreService.getTheatreById(id);
		if(theatre.isEmpty()) {
			throw new TheatreNotFoundException("Theatre not found with id "+ id);
		}
		
		show.setTheatre(theatre.get());
		Show addedShow = showService.addShows(show);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addedShow.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("theatres/{id}/shows")
	public List<Show> listTheatreShows(@PathVariable Integer id) {
		
		Optional<Theatre> theatre = theatreService.getTheatreById(id);
		if(theatre.isEmpty()) {
			throw new TheatreNotFoundException("Theatre not found with id "+ id);
		}
		
		return showService.getAllShows();
		
		
	}
	
	@DeleteMapping("shows/{id}")
	public void deleteShow(@PathVariable Integer id) {
		
		showService.deleteShowById(id);
		
		
	}
	
	@PatchMapping("shows/{id}")
	public Show updateShow(@PathVariable Integer id,@RequestBody Map<String,Object> values) {
		Optional<Show> show = showService.getShowById(id);
		if(show.isPresent()) {
			values.forEach((key,value)->{
				Field field = ReflectionUtils.findRequiredField(Show.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, show.get(), value);
			});
		}
		return showService.addShows(show.get());
		
	}
	
	
			
		
	

}
