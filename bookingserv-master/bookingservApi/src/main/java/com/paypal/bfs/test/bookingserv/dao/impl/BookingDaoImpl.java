package com.paypal.bfs.test.bookingserv.dao.impl;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingDao;
import com.paypal.bfs.test.bookingserv.datasource.HibernateUtil;
import com.paypal.bfs.test.bookingserv.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingDaoImpl implements BookingDao {

	@Override
	public BookingEntity create(BookingEntity bookingEntity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Integer addressId = (Integer) session.save(bookingEntity.getAddress());
		Integer bookingId = (Integer) session.save(bookingEntity);
		transaction.commit();
		session.close();
		bookingEntity.setId(bookingId);
		return bookingEntity;

	}

	@Override
	public List<Booking> getAllBookings() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String query = "from BookingEntity bookings";
		Query query2 = session.createQuery(query);
		List<BookingEntity> bookingEntityList = query2.getResultList();
		transaction.commit();
		session.close();
		List<Booking> bookingList = new ArrayList<>();
		for (BookingEntity entity : bookingEntityList)
			bookingList.add(createEntryFromEntity(entity));
		return bookingList;
	}

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
}
