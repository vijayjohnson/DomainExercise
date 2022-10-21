package com.interview.domainexercise.ticketbookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.interview.domainexercise.ticketbookingservice.entity.Show;
import com.interview.domainexercise.ticketbookingservice.repositories.ShowRepository;

@Component
public class ShowService {
	
	private ShowRepository showRepository;

	public ShowService(ShowRepository showRepository) {
		super();
		this.showRepository = showRepository;
	}
	
	public Show addShows(Show show) {
		
		return showRepository.save(show);
	}
	
	public List<Show> getAllShows(){
		
		return showRepository.findAll();
	}
	
	public Optional<Show> getShowById(Integer id) {
		
		return showRepository.findById(id);
	}
	
	public void deleteShowById(Integer id) {
		
		showRepository.deleteById(id);
		
		
	}
	
	

}
