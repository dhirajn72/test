package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface BookingResource {
	/**
	 * Create {@link Booking} resource
	 *
	 * @param booking the booking object
	 * @return the created booking
	 */
	@RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
	public ResponseEntity<Booking> create(@RequestBody Booking booking);

	@RequestMapping(value = "/v1/bfs/bookings", method = RequestMethod.GET)
	public ResponseEntity<List<Booking>> getAllBookings();

}
