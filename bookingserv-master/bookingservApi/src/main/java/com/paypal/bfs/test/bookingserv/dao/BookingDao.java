package com.paypal.bfs.test.bookingserv.dao;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;

import java.util.List;

public interface BookingDao {
	BookingEntity create(BookingEntity entity);

	List<Booking> getAllBookings();
}
