package com.example.onlinestore.services;

import com.example.onlinestore.entities.script.User;

import java.util.List;

public interface userManagementService {

    List<User> getListOfUsers();
    User getUserByEmail(String email);
}

