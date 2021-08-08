package com.paypal.bfs.test.bookingserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.paypal.bfs.test.bookingserv", "com.paypal.bfs.test.bookingserv.impl","com.paypal.bfs.test.bookingserv.datasource",
        "com.paypal.bfs.test.bookingserv.api","com.paypal.bfs.test.bookingserv.dao","com.paypal.bfs.test.bookingserv.exception","com.paypal.bfs.test.bookingserv.dao.impl"})
public class BookingServApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServApplication.class, args);
    }
}