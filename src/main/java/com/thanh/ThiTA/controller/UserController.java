package com.thanh.ThiTA.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.ThiTA.model.User;
import com.thanh.ThiTA.service.UserService;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/")
    public String Index(){
        return "OK";
    }

    @GetMapping(path = "/getAllUsers")
    public List<User> getAllUserNames(){
        return userService.getAllUserNames();
    }
}