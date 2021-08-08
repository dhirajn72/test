package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingDao;
import com.paypal.bfs.test.bookingserv.exception.ConstraintViolationException;
import com.paypal.bfs.test.bookingserv.exception.Errors;
import com.paypal.bfs.test.bookingserv.impl.BookingResourceImpl;
import com.paypal.bfs.test.bookingserv.impl.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class BookingAPITest {

	@Mock
	BookingDao bookingDao;

	BookingResourceImpl bookingResource = null;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.bookingResource = new BookingResourceImpl();
		bookingResource.setBookingDao(bookingDao);

	}

	@Test
	public void testBookingCreateApiValidations() throws ParseException {
		Booking booking = getBookingObject();
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_FIRST_NAME.getMessage(), e.getMessage());
		}
		booking.setFirstName("Alon");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_LAST_NAME.getMessage(), e.getMessage());
		}
		booking.setLastName("Musk");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_CHECKIN.getMessage(), e.getMessage());
		}
		booking.setCheckin("500");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_CHECKOUT.getMessage(), e.getMessage());
		}
		booking.setCheckout("300");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_DEPOSIT.getMessage(), e.getMessage());
		}
		booking.setDeposit(400);
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_DOB.getMessage(), e.getMessage());
		}
		booking.setDob(ObjectMapper.simpleDateFormat.parse("1990-9-9"));
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_TOTALPRICE.getMessage(), e.getMessage());
		}
		booking.setTotalprice(5000);
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_ADRESS.getMessage(), e.getMessage());
		}
		booking.setAddress(new Address());

		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_LINE1.getMessage(), e.getMessage());
		}
		booking.getAddress().setLine1("Salt Lake");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_CITY.getMessage(), e.getMessage());
		}
		booking.getAddress().setCity("New York");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_STATE.getMessage(), e.getMessage());
		}
		booking.getAddress().setState("Arizona");
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_COUNTRY.getMessage(), e.getMessage());
		}
		booking.getAddress().setCountry("USA");
		booking.setDob(ObjectMapper.simpleDateFormat.parse("1990-09-09"));
		try {
			bookingResource.create(booking);
		} catch (ConstraintViolationException e) {
			Assert.assertEquals(Errors.INVALID_ZIPCODE.getMessage(), e.getMessage());
		}
	}

	/**
	 * When there is no data passed
	 *
	 * @return
	 */
	private Booking getBookingObject() {
		Booking booking = new Booking();
		return booking;
	}
}
