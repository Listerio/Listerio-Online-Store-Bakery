package com.example.onlinestore.facade;


import com.example.onlinestore.entities.script.User;

import java.sql.SQLException;

public interface UserFacade {

    void  RegisterUser(User user);
    public void changePassword(int userId,String newPassword) throws SQLException;
    public void changeEmail(String newMail,int userId) throws SQLException;
    User getUser(String email,String password);

    boolean doesUserExist(User user );
}
