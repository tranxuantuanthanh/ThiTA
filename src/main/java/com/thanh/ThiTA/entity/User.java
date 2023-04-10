package com.thanh.ThiTA.entity;


public class User {
    private int id;
    private String password;
    private String fullName;
    private String city;
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public User() {
    }
    public User(int userId, String password, String fullName, String city) {
        this.id = userId;
        this.password = password;
        this.fullName = fullName;
        this.city = city;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
