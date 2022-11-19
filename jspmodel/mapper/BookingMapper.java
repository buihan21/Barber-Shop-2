package com.jspmodel.mapper;

import com.jspmodel.models.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper<Booking>{
    @Override
    public Booking mapRow(ResultSet res) {
        try {
            Booking booking = new Booking();
            booking.setId(res.getInt("id"));
            booking.setUser_id(res.getInt("user_id"));
            booking.setService_id(res.getInt("service_id"));
            booking.setEmployee_id(res.getInt("employee_id"));
            booking.setSet_hour(res.getTime("set_hour"));
            booking.setSet_date(res.getDate("set_date"));
            booking.setNote(res.getString("note"));
            return booking;
        } catch (SQLException e) {
            return null;
        }
    }
}
