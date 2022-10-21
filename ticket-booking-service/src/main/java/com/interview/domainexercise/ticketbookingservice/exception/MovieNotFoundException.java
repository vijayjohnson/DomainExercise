package com.interview.domainexercise.ticketbookingservice.exception;

public class MovieNotFoundException extends RuntimeException {
	
	private String message;

	public MovieNotFoundException(String message) {
		super(message);
		
	}

}
