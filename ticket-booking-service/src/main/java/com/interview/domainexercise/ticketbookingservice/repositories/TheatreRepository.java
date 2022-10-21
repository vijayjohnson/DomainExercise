package com.interview.domainexercise.ticketbookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.domainexercise.ticketbookingservice.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
