package com.jspmodel.service.impl;

import com.jspmodel.dao.IBookingDAO;
import com.jspmodel.models.Booking;
import com.jspmodel.service.IBookingService;

import javax.inject.Inject;

public class BookingService implements IBookingService {
    @Inject
    private IBookingDAO bookingDAO;


    @Override
    public Booking findBooking(Booking booking) {
        if (bookingDAO.checkBooking(booking))
            bookingDAO.save(booking);
        return null;
    }

    @Override
    public Booking save(Booking booking) {
        //booking.setSet_hour(new Time(System.currentTimeMillis()));
        Integer bookingId = bookingDAO.save(booking);
        return bookingDAO.findOne(bookingId);
    }

    @Override
    public Booking update(Booking updateBooking) {
        Booking oldBooking = bookingDAO.findOne(updateBooking.getId());
        bookingDAO.update(updateBooking);
        return bookingDAO.findOne(updateBooking.getId());
    }

    @Override
    public void delete(Integer id) {
//        for (Integer id : ids){
            bookingDAO.delete(id);
        }
//    }
}
