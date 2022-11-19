package com.jspmodel.service;

import com.jspmodel.models.Booking;

public interface IBookingService {
    Booking findBooking(Booking booking);
    Booking save(Booking booking);
    Booking update(Booking updateBooking);
    void delete(Integer id);
}
