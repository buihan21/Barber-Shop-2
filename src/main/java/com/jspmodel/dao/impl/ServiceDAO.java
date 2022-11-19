package com.jspmodel.dao.impl;

import com.jspmodel.dao.IServiceDAO;
import com.jspmodel.mapper.ServiceMapper;
import com.jspmodel.models.Booking;
import com.jspmodel.models.Service;

import java.util.List;

public class ServiceDAO extends AbstractDAO<Service> implements IServiceDAO {
    @Override
    public List<Service> fillAll() {
        String sql = "SELECT * FROM Service";
        return query(sql, new ServiceMapper());
    }
}
