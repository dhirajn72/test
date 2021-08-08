package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingDao;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookingResourceImpl implements BookingResource {

	private final Logger logger = Logger.getLogger(BookingResourceImpl.class.getName());

	@Autowired
	private BookingDao bookingDao;

	@Override
	public ResponseEntity<Booking> create(Booking booking) {
		BookingEntity entity = bookingDao.create(ObjectMapper.createEntityFromEntry(booking));
		booking = ObjectMapper.createEntryFromEntity(entity);
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> bookingList = bookingDao.getAllBookings();
		return new ResponseEntity<>(bookingList, HttpStatus.OK);
	}

	public BookingDao getBookingDao() {
		return bookingDao;
	}

	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}
}
