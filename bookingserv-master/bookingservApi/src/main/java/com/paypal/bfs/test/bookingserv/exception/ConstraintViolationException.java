package com.paypal.bfs.test.bookingserv.exception;

public class ConstraintViolationException extends RuntimeException{
	ApiError apiError;
	public ConstraintViolationException(ApiError apiError){
		super(apiError.getMessage());
		this.apiError=apiError;
	}
}
