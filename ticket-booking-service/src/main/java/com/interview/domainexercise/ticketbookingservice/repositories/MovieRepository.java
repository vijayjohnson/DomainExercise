package com.interview.domainexercise.ticketbookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.domainexercise.ticketbookingservice.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
