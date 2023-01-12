package com.example.onlinestore.services.impl;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.services.userManagementService;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserManagementService implements userManagementService {
    List<User> users;
    User user;

    @Override
    public List<User> getListOfUsers() {
        users=new ArrayList<>();
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        if (user.getEmail().equals(email)) {
            return user;
        }
        return null;
    }


}
