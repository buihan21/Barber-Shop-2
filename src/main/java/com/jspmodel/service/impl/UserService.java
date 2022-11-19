package com.jspmodel.service.impl;

import com.jspmodel.dao.IUserDAO;
import com.jspmodel.models.User;
import com.jspmodel.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;

    @Override
    public User findByUserNameAndPassWord(String userName, String passWord) {
        return userDAO.findByUserNameAndPassword(userName, passWord);
    }
}
