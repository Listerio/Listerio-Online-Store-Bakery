package com.example.onlinestore.entities.impl;

import com.example.onlinestore.dao.Impl.DefaultUserDao;
import com.example.onlinestore.dao.UserDao;
import com.example.onlinestore.entities.script.User;

import java.sql.SQLException;

public class DefaultUser implements User {
    UserDao retrieve=new DefaultUserDao();

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    public DefaultUser() {

    }

    public DefaultUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DefaultUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public DefaultUser(int userId, String firstName, String lastName, String email, String password, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    @Override
    public String   getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public int getUserId() {
        try {
            userId=retrieve.getUserId(this.email,this.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userId;

    }
    @Override
    public void setUserId(int userId) {
        this.userId=userId;
    }
    @Override
    public void setUserEmail(String userEmail) {
    this.email=userEmail;
    }
    @Override
    public void setUserPassword(String userPassword) {
        this.password=userPassword;
    }
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }


}