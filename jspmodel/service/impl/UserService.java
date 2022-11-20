package com.jspmodel.service.impl;

import com.jspmodel.dao.IUserDAO;
import com.jspmodel.models.User;
import com.jspmodel.models.User;
import com.jspmodel.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;

	@Override
	public User findByUserNameAndPassword(String userName, String passWord) {
		return userDAO.findByUserNameAndPassword(userName, passWord);
	}
	@Override
	public User save(User user) {
		Integer userId = userDAO.save(user);
        return userDAO.findOne(userId);
	}
	@Override
	public User update(User updateUser) {
        User oldUser = userDAO.findOne(updateUser.getId());
        userDAO.update(updateUser);
        return userDAO.findOne(updateUser.getId());
    }
	@Override
	public void delete(Integer id) {
		
		userDAO.delete(id);
	}
}
