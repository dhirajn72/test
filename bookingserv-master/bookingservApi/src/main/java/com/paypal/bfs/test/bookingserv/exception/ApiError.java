package com.paypal.bfs.test.bookingserv.exception;

import org.springframework.http.HttpStatus;

public class ApiError {
    private HttpStatus status;
    private String message;
    private int errorCode;

    public ApiError(HttpStatus status, String message, int errors) {
        super();
        this.status = status;
        this.message = message;
        this.errorCode = errors;
    }
    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
