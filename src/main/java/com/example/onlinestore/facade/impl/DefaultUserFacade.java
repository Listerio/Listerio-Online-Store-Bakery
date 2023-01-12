package com.example.onlinestore.facade.impl;


import com.example.onlinestore.dao.Impl.DefaultUserDao;
import com.example.onlinestore.dao.UserDao;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.facade.UserFacade;

import java.sql.SQLException;

public class DefaultUserFacade implements UserFacade {
    UserDao userDb=new DefaultUserDao();

    @Override
    public void RegisterUser(User user) {
        try {
            userDb.RegisterUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changePassword(int userId, String newPassword) throws SQLException {
        userDb.changePassword(userId,newPassword);

    }

    @Override
    public void changeEmail(String newMail, int userId) throws SQLException {
        userDb.changeEmail(newMail,userId);
    }


    @Override
    public User getUser(String email, String password) {
        try {
            return userDb.getUser(email,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean doesUserExist(User user) {
        try {
            return userDb.doesUSerExist(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
