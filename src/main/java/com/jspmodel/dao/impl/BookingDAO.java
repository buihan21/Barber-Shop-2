package com.jspmodel.dao.impl;

import com.jspmodel.dao.IBookingDAO;
import com.jspmodel.mapper.BookingMapper;
import com.jspmodel.models.Booking;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class BookingDAO extends AbstractDAO<Booking> implements IBookingDAO {

    @Override
    public Booking findOne(int id) {
        String sql = "SELECT * FROM [Booking] WHERE id = ?";
        List<Booking> bookingList = query(sql, new BookingMapper(), id);
        if (bookingList.isEmpty()){
            return null;
        }
        return bookingList.get(0);
    }

    @Override
    public Integer save(Booking booking) {
        String sql = "INSERT INTO Booking(user_id, service_id, employee_id, set_hour, set_date)\n"
                    + "VALUES (?,?,?,?,?)";
        return insert(sql, booking.getUser_id(), booking.getService_id(), booking.getEmployee_id(),
                        booking.getSet_hour(), booking.getSet_date());

    }

    @Override
    public boolean checkBooking(Booking booking) {
        Time hour = booking.getSet_hour();
        Date date = booking.getSet_date();
        int employee_id = booking.getEmployee_id();
        StringBuilder sql = new StringBuilder("SELECT * FROM Booking");
        sql.append("WHERE set_hour = ? AND set_date = ? AND employee_id = ?");
        List<Booking> bookings = query(sql.toString(), new BookingMapper(), hour, date, employee_id);
        if (bookings.isEmpty())
            return true;
        return false;
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Booking WHERE id = ?";
        update(sql, id);
    }

    @Override
    public void update(Booking updateBooking) {
        String sql = "UPDATE Booking SET user_id = ?, service_id = ?, employee_id = ?, set_hour = ?, set_date = ? WHERE id = ?";
        update(sql, updateBooking.getUser_id(), updateBooking.getService_id(), updateBooking.getEmployee_id(), updateBooking.getSet_hour(),
                updateBooking.getSet_date(), updateBooking.getId());
    }
}
