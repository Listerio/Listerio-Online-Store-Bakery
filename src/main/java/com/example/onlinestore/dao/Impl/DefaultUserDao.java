package com.example.onlinestore.dao.Impl;
import com.example.onlinestore.DbUtil;
import com.example.onlinestore.dao.UserDao;
import com.example.onlinestore.entities.impl.DefaultUser;
import com.example.onlinestore.entities.script.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultUserDao implements UserDao {
    private String query;

    @Override
    public void RegisterUser(User user) throws SQLException {

        query="INSERT INTO `online_store`.`user_table` (`user_first_name`, `user_last_name`," +
                " `user_phone_number`," +
                    " `user_email`, `user_password`) VALUES (?,?,?,?,?)";

        try(Connection connection= DbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(query)){
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getPhoneNumber());
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getPassword());
            statement.executeUpdate();
        }

    }
    public  int getUserId(String email,String password) throws SQLException{
        query="Select user_id from user_table where user_email=? and user_password=?";
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
            statement.setString(1,email);
            statement.setString(2,password);
            try(ResultSet set=statement.executeQuery()){
                while (set.next()){
                    return  set.getInt(1);
                }
            }

        }
        return 0;
    }

    public void changePassword(int userId,String newPassword) throws SQLException {
        query="UPDATE `online_store`.`user_table`  SET `user_password` =? WHERE (`user_id` = ?)";

        try(Connection connection= DbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)){
            statement.setString(1,newPassword);
            statement.setInt(2,userId);
            statement.executeUpdate();
        }
    }

    public void changeEmail(String newMail,int userId) throws SQLException {
        query="UPDATE `online_store`.`user_table`  SET `user_email` =? WHERE (`user_id` = ?)";
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)){
            statement.setString(1,newMail);
            statement.setInt(2,userId);
            statement.executeUpdate();
        }

    }

    public User getUser(String userEmailName,String userPassword) throws SQLException {
        User user=null;
        query="SELECT * from `online_store`.`user_table` where user_email=? and user_password=?";
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
            statement.setString(1,userEmailName);
            statement.setString(2,userPassword);
            try (ResultSet set=statement.executeQuery()){
                while (set.next()){
                    user=new DefaultUser(set.getInt(1),set.getString(2),
                            set.getString(3), set.getString(5),
                            set.getString(6),set.getString(4));
                }
            }
        }
        return user;
    }

    public boolean doesUSerExist(User user) throws SQLException {
        query="SELECT * from `online_store`.`user_table` where user_email=?";
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
             statement.setString(1,user.getEmail());
                try (ResultSet set=statement.executeQuery()){
                    while(set.next()){
                    return true;
                    }
                }
        }
        return false;
    }




}
