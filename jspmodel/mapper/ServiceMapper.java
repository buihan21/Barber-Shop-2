package com.jspmodel.mapper;

import com.jspmodel.models.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service>{
    @Override
    public Service mapRow(ResultSet res) {
        try {
            Service service = new Service();
            service.setId(res.getInt("id"));
            service.setName(res.getString("name"));
            service.setCost(res.getInt("cost"));
            return service;
        } catch (SQLException e) {
            return null;
        }
    }
}
