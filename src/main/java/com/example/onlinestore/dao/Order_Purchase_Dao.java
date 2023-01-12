package com.example.onlinestore.dao;

import com.example.onlinestore.entities.script.Order;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.services.Cart;

import java.sql.SQLException;
import java.util.List;

public interface Order_Purchase_Dao {

    void addOrder(Order o) throws SQLException;
    List<Order> getOrderList(User user) throws SQLException;
    List<Order> getOrders() throws SQLException;


}
