package com.paypal.bfs.test.bookingserv.exception;

import org.springframework.http.HttpStatus;

public class Errors {
	public static final ApiError INVALID_FIRST_NAME= new ApiError(HttpStatus.BAD_REQUEST, "First name is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_LAST_NAME= new ApiError(HttpStatus.BAD_REQUEST, "Last name is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_CHECKIN =new ApiError(HttpStatus.BAD_REQUEST, "Checkin is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_CHECKOUT =new ApiError(HttpStatus.BAD_REQUEST, "Checkout is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_DEPOSIT =new ApiError(HttpStatus.BAD_REQUEST, "Deposit is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_DOB =new ApiError(HttpStatus.BAD_REQUEST, "DOB is mandatory, please enter dob in yyyy-MM-dd format", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_TOTALPRICE =new ApiError(HttpStatus.BAD_REQUEST, "Total price is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_ADRESS =new ApiError(HttpStatus.BAD_REQUEST, "Address is mandatory", HttpStatus.BAD_REQUEST.value());

	public static final ApiError INVALID_LINE1 =new ApiError(HttpStatus.BAD_REQUEST, "Line1 is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_CITY =new ApiError(HttpStatus.BAD_REQUEST, "City is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_STATE =new ApiError(HttpStatus.BAD_REQUEST, "State is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_COUNTRY =new ApiError(HttpStatus.BAD_REQUEST, "Country is mandatory", HttpStatus.BAD_REQUEST.value());
	public static final ApiError INVALID_ZIPCODE =new ApiError(HttpStatus.BAD_REQUEST, "ZipCode is mandatory", HttpStatus.BAD_REQUEST.value());
}
