package com.example.onlinestore.services;

import com.example.onlinestore.entities.script.Order;
import com.example.onlinestore.entities.script.User;

import java.util.List;

    public interface OrderManagementService {

        void addOrder(Order order);

        List<Order> getOrdersByUserId(int userId);

        List<Order> getOrders();


    }