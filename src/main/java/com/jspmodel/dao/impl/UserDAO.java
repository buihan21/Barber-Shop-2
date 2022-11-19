package com.jspmodel.dao.impl;

import com.jspmodel.dao.IUserDAO;
import com.jspmodel.mapper.UserMapper;
import com.jspmodel.models.User;

import java.util.List;
import java.util.Objects;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {
    @Override
    public User findByUserNameAndPassword(String userName, String passWord) {
        StringBuilder sql = new StringBuilder("SELECT * FROM [User]");
        sql.append(" INNER JOIN [Role] ON Role.id = User.role_id");
        sql.append(" WHERE user_name = ? AND pass_word = ?");
        List<User> users = query(sql.toString(), new UserMapper(), userName, passWord);
        return users.isEmpty() ? null : users.get(0);
    }
}
