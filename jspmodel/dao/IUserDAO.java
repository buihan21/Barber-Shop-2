package com.jspmodel.dao;

import com.jspmodel.models.User;

public interface IUserDAO extends GenericDAO<User>{
	User findOne(int i);
    User findByUserNameAndPassword(String userName, String passWord);
    Integer save(User user);
    void update(User user);
    void delete(int id);
}
