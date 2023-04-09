package com.thanh.ThiTA.service.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thanh.ThiTA.model.User;

public class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setPassword(rs.getString("password"));
        user.setFullName(rs.getString("fullName"));
        user.setCity(rs.getString("city"));
        return user;
    }  
    
}
