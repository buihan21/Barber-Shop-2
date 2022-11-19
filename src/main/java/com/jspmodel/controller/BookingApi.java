/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jspmodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspmodel.mapper.BookingMapper;
import com.jspmodel.models.Booking;
import com.jspmodel.service.IBookingService;
import com.jspmodel.utils.HttpUtil;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/booking"})
public class BookingApi extends HttpServlet{
	@Inject
	private IBookingService BookingService;
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        res.setContentType("aplication/json");
        HttpUtil.of(req.getReader());
        Booking booking = HttpUtil.of(req.getReader()).toModel(Booking.class);
        booking = BookingService.save(booking);       
        mapper.writeValue(res.getOutputStream(), booking);
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        res.setContentType("aplication/json");	
        Booking updateBooking = HttpUtil.of(req.getReader()).toModel(Booking.class);
        updateBooking = BookingService.update(updateBooking);
        mapper.writeValue(res.getOutputStream(), updateBooking);
	}
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        res.setContentType("aplication/json");	
        Booking booking = HttpUtil.of(req.getReader()).toModel(Booking.class);   	
        BookingService.delete(booking.getId());
        mapper.writeValue(res.getOutputStream(), "{}");
    }
    
}
