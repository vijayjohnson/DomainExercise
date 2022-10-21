package com.interview.domainexercise.ticketbookingservice.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(TheatreNotFoundException.class)
	public final ResponseEntity<Object> handleTheatreNotFoundException(Exception ex, WebRequest request){
		
		ExceptionDetails details = new ExceptionDetails(LocalTime.now(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		ExceptionDetails details = new ExceptionDetails(LocalTime.now(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(MovieNotFoundException.class)
	public final ResponseEntity<Object> handleMovieNotFoundException(Exception ex, WebRequest request){
		
		ExceptionDetails details = new ExceptionDetails(LocalTime.now(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
	}

}
