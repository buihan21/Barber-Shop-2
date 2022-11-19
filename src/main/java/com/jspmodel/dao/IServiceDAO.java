package com.jspmodel.dao;

import com.jspmodel.models.Booking;
import com.jspmodel.models.Service;

import java.util.List;

public interface IServiceDAO extends GenericDAO<Service>{
    List<Service> fillAll();
}
