package com.interview.domainexercise.ticketbookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.domainexercise.ticketbookingservice.entity.Show;

public interface ShowRepository extends JpaRepository<Show,  Integer> {
	
	

}
