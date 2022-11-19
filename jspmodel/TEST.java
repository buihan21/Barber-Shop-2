package com.jspmodel;

import com.jspmodel.dao.impl.BookingDAO;
import com.jspmodel.models.Booking;
import com.jspmodel.service.impl.BookingService;

import java.sql.Date;
import java.sql.Time;

public class TEST {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();
        Booking booking = new Booking(3,2,1, Time.valueOf("14:00:00"), Date.valueOf("2022-11-10"));
        BookingService bookingService = new BookingService();
        bookingDAO.save(booking);
        bookingService.save(booking);
        //bookingService.save(booking);
    }
}
