package com.jspmodel.mapper;

import com.jspmodel.models.Role;
import com.jspmodel.models.User;
import sun.awt.geom.AreaOp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet res) {
        try {
            User user = new User();
            user.setId(res.getInt("id"));

            user.setRole_id(res.getInt("role_id"));
            try {
                Role role = new Role();
                role.setId(res.getInt("role_id"));
                role.setName(res.getString("name"));
                user.setRole(role);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            user.setUser_name(res.getString("user_name"));
            user.setPass_word(res.getString("pass_word"));
            user.setName(res.getString("name"));
            user.setPhone_number(res.getString("phone_number"));

            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
