package com.jspmodel.dao;

import com.jspmodel.models.Booking;

public interface IBookingDAO extends GenericDAO<Booking>{
    Booking findOne(int id);
    Integer save(Booking booking);
    boolean checkBooking(Booking booking);
    void delete(int id);
    void update(Booking updateBooking);
}
