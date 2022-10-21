package com.interview.domainexercise.ticketbookingservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interview.domainexercise.ticketbookingservice.entity.Theatre;
import com.interview.domainexercise.ticketbookingservice.exception.TheatreNotFoundException;
import com.interview.domainexercise.ticketbookingservice.service.TheatreService;

@RestController
public class TheatreController {
	
	private TheatreService theatreService;
	
	
	
	public TheatreController(TheatreService theatreService) {
		super();
		this.theatreService = theatreService;
	}



	@PostMapping("theatres")
	public ResponseEntity addTheatre(@RequestBody Theatre theatre) {
		
		Theatre newTheatre = theatreService.addNewTheatre(theatre);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(newTheatre.getTheatre_Id()).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping("theatres")
	public List<Theatre> getTheatres(){
		
		return theatreService.getAllTheatres();
	}
	
	@GetMapping("theatres/{id}")
	public Theatre getTheatreById(@PathVariable Integer id) {
		
		Optional<Theatre> theatre =theatreService.getTheatreById(id);
		if(!theatre.isPresent()) {
			 throw new TheatreNotFoundException("Theatre Not Found with id"+id);
		}
		return theatre.get();
	}
		
	

}
