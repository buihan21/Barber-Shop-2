package com.jspmodel.service.impl;

import com.jspmodel.dao.IServiceDAO;
import com.jspmodel.models.Service;
import com.jspmodel.service.IServiceService;

import javax.inject.Inject;
import java.util.List;

public class ServiceService implements IServiceService {
    @Inject
    private IServiceDAO serviceDAO;

    @Override
    public List<Service> fillAll() {
        return serviceDAO.fillAll();
    }
}
