package com.interview.domainexercise.ticketbookingservice.exception;

import java.time.LocalTime;

public class ExceptionDetails {
	
	private LocalTime currentTime;
	private String message;
	private String description;
	
	public ExceptionDetails(LocalTime currentTime, String message, String description) {
		super();
		this.currentTime = currentTime;
		this.message = message;
		this.description = description;
	}

}
