package com.example.onlinestore.dao;


import com.example.onlinestore.entities.script.User;

import java.sql.SQLException;

public interface UserDao {

    void RegisterUser(User user) throws SQLException;
    void changePassword(int userId,String newPassword) throws SQLException;
    void changeEmail(String newMail,int userId) throws SQLException;
    User getUser(String email,String password) throws SQLException;
    int getUserId(String email,String password) throws SQLException;
    boolean doesUSerExist(User user) throws SQLException;


}
