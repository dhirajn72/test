package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.ConstraintViolationException;
import com.paypal.bfs.test.bookingserv.exception.Errors;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ObjectMapper {
	private static String pattern = "yyyy-MM-dd";
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	public static Booking createEntryFromEntity(BookingEntity entity) {
		Booking entry = new Booking();
		entry.setId(entity.getId());
		entry.setFirstName(entity.getFirstName());
		entry.setLastName(entity.getLastName());
		entry.setCheckin(entity.getCheckin());
		entry.setCheckout(entity.getCheckout());
		entry.setDeposit(entity.getDeposit().intValue());
		entry.setDob(entity.getDob().toString());
		entry.setTotalprice(Double.valueOf(entity.getTotalprice() + ""));
		entry.setAddress(createEntryFromEntity(entity.getAddress()));
		return entry;
	}

	public static Address createEntryFromEntity(AddressEntity address) {
		Address entry = new Address();
		entry.setCity(address.getCity());
		entry.setCountry(address.getCountry());
		entry.setLine1(address.getLine1());
		entry.setLine2(address.getLine2());
		entry.setZipcode(address.getZipcode());
		entry.setState(address.getState());
		return entry;
	}

	public static BookingEntity createEntityFromEntry(Booking booking) {
		validateBookingRequest(booking);
		BookingEntity entity = new BookingEntity();
		entity.setFirstName(booking.getFirstName());
		entity.setLastName(booking.getLastName());
		entity.setCheckin(booking.getCheckin());
		entity.setCheckout(booking.getCheckout());
		entity.setDeposit(Double.valueOf(booking.getDeposit()));
		try {
			entity.setDob(simpleDateFormat.parse(booking.getDob().toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		entity.setTotalprice(Double.valueOf(booking.getTotalprice() + ""));
		entity.setAddress(createEntityFromEntry(booking.getAddress()));
		return entity;
	}

	public static void validateBookingRequest(Booking booking) {
		if (booking.getFirstName() == null || booking.getFirstName().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_FIRST_NAME);

		if (booking.getLastName() == null || booking.getLastName().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_LAST_NAME);

		if (booking.getCheckin() == null || booking.getCheckin().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_CHECKIN);

		if (booking.getCheckout() == null || booking.getCheckout().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_CHECKOUT);

		if (booking.getDeposit() == null)
			throw new ConstraintViolationException(Errors.INVALID_DEPOSIT);

		if (booking.getDob() == null)
			throw new ConstraintViolationException(Errors.INVALID_DOB);

		if (booking.getTotalprice() == null)
			throw new ConstraintViolationException(Errors.INVALID_TOTALPRICE);

		if (booking.getAddress() == null)
			throw new ConstraintViolationException(Errors.INVALID_ADRESS);

	}

	public static AddressEntity createEntityFromEntry(Address address) {
		validateAddressRequest(address);
		AddressEntity entity = new AddressEntity();
		entity.setCity(address.getCity());
		entity.setCountry(address.getCountry());
		entity.setLine1(address.getLine1());
		entity.setLine2(address.getLine2());
		entity.setZipcode(address.getZipcode());
		entity.setState(address.getState());
		return entity;
	}

	public static void validateAddressRequest(Address address) {
		if (address.getLine1() == null || address.getLine1().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_LINE1);

		if (address.getCity() == null || address.getCity().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_CITY);

		if (address.getState() == null || address.getState().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_STATE);

		if (address.getCountry() == null || address.getCountry().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_COUNTRY);

		if (address.getZipcode() == null || address.getZipcode().isEmpty())
			throw new ConstraintViolationException(Errors.INVALID_ZIPCODE);
	}
}
