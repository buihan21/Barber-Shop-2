package com.jspmodel.dao.impl;

import com.jspmodel.dao.IUserDAO;
import com.jspmodel.mapper.UserMapper;
import com.jspmodel.mapper.UserMapper;
import com.jspmodel.models.User;
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
    @Override
    public User findOne(int id) {
        String sql = "SELECT * FROM [User] WHERE id = ?";
        List<User> userList = query(sql, new UserMapper(), id);
        if (userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }
    @Override
    public Integer save(User user) {
        String sql = "INSERT INTO User(role_id, user_name, pass_word, name, phone_number)\n"
                    + "VALUES (?,?,?,?,?)";
        return insert(sql, user.getRole_id(), user.getUser_name(), user.getPass_word(),
                        user.getName(), user.getPhone_number());

    }
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM User WHERE id = ?";
        update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE User SET role_id = ?, user_name = ?, pass_word = ?, name = ?, phone_number = ? WHERE id = ?";
        update(sql, user.getRole_id(), user.getUser_name(), user.getPass_word(),
                user.getName(), user.getPhone_number());
    }
}
