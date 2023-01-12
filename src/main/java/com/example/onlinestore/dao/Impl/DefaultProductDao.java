package com.example.onlinestore.dao.Impl;

import com.example.onlinestore.DbUtil;
import com.example.onlinestore.entities.impl.DefaultPrice;
import com.example.onlinestore.entities.impl.DefaultProduct;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.entities.script.enums.Category;
import com.example.onlinestore.entities.script.enums.SubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultProductDao {


    private List<Product> products;
    private String query;


    public void addProductsToDb(Product product) throws SQLException {
        if (!checkIfProductExists(product)){
        query = "INSERT INTO `online_store`.`product` (`product_name`," +
                " `product_description`, `product_price`" +
                ", `product_image_location`, `product_category`, `product_sub_category`)" +
                " VALUES (?,?,?,?,?,?)";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductDescription());
            statement.setDouble(3, product.getProductPrice().getPrice());
            statement.setString(4, product.getProductImageLocation());
            statement.setString(5, product.getProductCategory().toString());
            statement.setString(6, product.getProductSubCategory().toString());
            statement.executeUpdate();
            }
        }
    }

    private boolean checkIfProductExists(Product product) throws SQLException {
        query="Select product_name from `online_store`.`product` where product_name=? ";
       try(Connection connection=DbUtil.getConnection();
           PreparedStatement statement= connection.prepareStatement(query)){
               statement.setString(1,product.getProductName());
               try (ResultSet set= statement.executeQuery()){
                   while (set.next()){
                       return true;
                   }
               }
       }
       return false;
    }
    public Product retrieveProductById(int id) throws SQLException {
        query = "Select * from `online_store`.`product` where product_id=?";
        Product product=null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    product = new DefaultProduct();
                    product.setProductId(set.getInt(1));
                    product.setProductName(set.getString(2));
                    product.setProductDescription(set.getString(3));
                    product.setProductPrice(new DefaultPrice(set.getDouble(4)));
                    product.setProductImageLocation(set.getString(5));
                    product.setProductCategory(Category.valueOf(set.getString(6)));
                    product.setProductSubCategory(SubCategory.valueOf(set.getString(7)));
                }
            }
        }
        return product;
    }

    public List<Product> retrieveProductByCategory(Category category)throws SQLException{
        query="Select * from `online_store`.`product` where product_category=?";
        products=new ArrayList<>();
        Product product=null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.toString());
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    product = new DefaultProduct();
                    product.setProductId(set.getInt(1));
                    product.setProductName(set.getString(2));
                    product.setProductDescription(set.getString(3));
                    product.setProductPrice(new DefaultPrice(set.getDouble(4)));
                    product.setProductImageLocation(set.getString(5));
                    product.setProductCategory(Category.valueOf(set.getString(6)));
                    product.setProductSubCategory(SubCategory.valueOf(set.getString(7)));
                    products.add(product);
                }
            }
        }
        return products;
    }

    public List<Product> retrieveProductBySubCategory(SubCategory subCategory)throws SQLException{
        query="Select * from `online_store`.`product` where product_sub_category=?";
        products=new ArrayList<>();
        Product product=null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subCategory.toString());
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    product = new DefaultProduct();
                    product.setProductId(set.getInt(1));
                    product.setProductName(set.getString(2));
                    product.setProductDescription(set.getString(3));
                    product.setProductPrice(new DefaultPrice(set.getDouble(4)));
                    product.setProductImageLocation(set.getString(5));
                    product.setProductCategory(Category.valueOf(set.getString(6)));
                    product.setProductSubCategory(SubCategory.valueOf(set.getString(7)));
                    products.add(product);
                }
            }
        }
        return products;
    }



}







