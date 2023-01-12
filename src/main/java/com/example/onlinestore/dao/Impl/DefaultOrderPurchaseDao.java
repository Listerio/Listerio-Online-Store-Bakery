package com.example.onlinestore.dao.Impl;

import com.example.onlinestore.DbUtil;
import com.example.onlinestore.dao.Order_Purchase_Dao;
import com.example.onlinestore.entities.impl.DefaultOrder;
import com.example.onlinestore.entities.script.Order;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.services.Cart;
import com.example.onlinestore.services.ProductManagementService;
import com.example.onlinestore.services.impl.DefaultProductManagementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DefaultOrderPurchaseDao implements Order_Purchase_Dao {

    private String query;



    @Override
    public void addOrder(Order order) throws SQLException {
        List<Product> productList=order.getProducts();
        query="INSERT INTO `online_store`.`purchase`" +
                " (`fk_user_purchase`, `fk_product_purchase`) VALUES (?,?)";
      try(Connection conn= DbUtil.getConnection();

         PreparedStatement statement= conn.prepareStatement(query)){
          for (Product p:productList)
             {
                statement.setInt(1,order.getUser().getUserId());
                statement.setInt(2,p.getProductId());
                statement.executeUpdate();
             }
         }
    }

    @Override
    public List<Order> getOrderList(User user) throws SQLException {
        Order order=new DefaultOrder();
        List<Order> orders = new ArrayList<>();
        List<Product> productList=new ArrayList<>();
        ProductManagementService productManagementService=new DefaultProductManagementService();
        query="Select * from online_store.purchase where fk_user_purchase=?";
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement stat= connection.prepareStatement(query)){
            stat.setInt(1,user.getUserId());
            try(ResultSet set=stat.executeQuery()){
                while (set.next()){
                    productList.add(productManagementService.getProductByProductId
                            (set.getInt("fk_product_purchase")));
                }
                order.setProducts(productList);
            }
        }
        orders.add(order);
        return orders;
    }

    @Override
    public List<Order> getOrders() throws SQLException {
        List<Order> orderList=new ArrayList<>();
        List<Product> products=new ArrayList<>();
        query="SELECT * FROM online_store.purchase";
        try(Connection conn=DbUtil.getConnection();
            PreparedStatement statement= conn.prepareStatement(query)){
            try(ResultSet set=statement.executeQuery()){
                while(set.next()){
                ProductManagementService service=new DefaultProductManagementService();
                products.add(service.getProductByProductId(set.getInt(3)));
                }
            Order order=new DefaultOrder();
              order.setProducts(products);
                orderList.add(order);
            }
        }
        return orderList;
    }
}
