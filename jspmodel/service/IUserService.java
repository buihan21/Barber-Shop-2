package com.jspmodel.service;


import com.jspmodel.models.User;

public interface IUserService {
    User findByUserNameAndPassword(String userName, String passWord);
    User save(User user);
    User update(User user);
    void delete(Integer id);
}
