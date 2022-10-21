package com.interview.domainexercise.ticketbookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.interview.domainexercise.ticketbookingservice.entity.Theatre;
import com.interview.domainexercise.ticketbookingservice.repositories.TheatreRepository;
@Component
public class TheatreService {
	
	private TheatreRepository theatreRepository;

	public TheatreService(TheatreRepository theatreRepository) {
		super();
		this.theatreRepository = theatreRepository;
	}
	
	public Theatre addNewTheatre(Theatre theatre) {
		
		return theatreRepository.save(theatre);
		
	}
	
	public List<Theatre> getAllTheatres(){
		
		return theatreRepository.findAll();
	}
	
	public Optional<Theatre> getTheatreById(Integer id) {
		
		return theatreRepository.findById(id);
		
		
		
	}
	
	

}
