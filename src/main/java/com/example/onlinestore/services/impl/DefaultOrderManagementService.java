package com.example.onlinestore.services.impl;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.dao.Impl.DefaultOrderPurchaseDao;
import com.example.onlinestore.entities.script.Order;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.services.Cart;
import com.example.onlinestore.services.OrderManagementService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultOrderManagementService implements OrderManagementService {
    ApplicationContext context;
    private List<Order> orderList;
    private DefaultOrderPurchaseDao dao;
    public DefaultOrderManagementService() {
        orderList = new ArrayList<>();
    }

    {
        dao= new DefaultOrderPurchaseDao();
        context=ApplicationContext.getInstance();

    }
    /**
     * @param order after purchase
     */

    @Override
    public void addOrder(Order order) {
        try {
            dao.addOrder(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> userOrder = null;
        List<Order>returnOrder=null;
        try {
            userOrder = dao.getOrders();
            returnOrder=new ArrayList<>();
            for (Order o: userOrder) {
                if (o.getCustomerId()==userId){
                    returnOrder.add(o);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return returnOrder;
    }

    @Override
    public List<Order> getOrders() {
        try {
            return dao.getOrders();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void clear() {

        orderList.clear();

    }

}