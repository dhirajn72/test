package com.paypal.bfs.test.bookingserv.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionHandler {
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolationExceptions(ConstraintViolationException exception) {
		return new ResponseEntity<Object>(exception.apiError, new HttpHeaders(), exception.apiError.getStatus());
	}
}
