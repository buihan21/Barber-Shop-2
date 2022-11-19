package com.jspmodel.service;

import com.jspmodel.models.User;

public interface IUserService {
    User findByUserNameAndPassWord(String userName, String passWord);
}
