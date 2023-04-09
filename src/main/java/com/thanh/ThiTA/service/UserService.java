package com.thanh.ThiTA.service;

import java.util.ArrayList;
import java.util.List;

import com.thanh.ThiTA.model.User;
import com.thanh.ThiTA.service.RowMapper.UserRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUserNames(){
        List<User> listUsers = new ArrayList<>();
        listUsers = jdbcTemplate.query("select * from user;", new UserRowMapper());
        return listUsers;
    }
}
