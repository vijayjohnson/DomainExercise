package com.interview.domainexercise.ticketbookingservice.exception;

public class TheatreNotFoundException extends RuntimeException {
	
	private String message;
	public TheatreNotFoundException() {
		
	}
	public TheatreNotFoundException(String message) {
		super(message);
		
	}

}
