package com.jspmodel.dao;

import com.jspmodel.models.User;

public interface IUserDAO extends GenericDAO<User>{
    User findByUserNameAndPassword(String userName, String passWord);

}
