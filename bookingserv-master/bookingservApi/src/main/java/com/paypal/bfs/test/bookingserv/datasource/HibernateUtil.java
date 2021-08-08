package com.paypal.bfs.test.bookingserv.datasource;

import com.paypal.bfs.test.bookingserv.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration()
				.configure().addAnnotatedClass(BookingEntity.class).addAnnotatedClass(AddressEntity.class);
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = (ServiceRegistry) standardServiceRegistryBuilder.build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
