package com.example.onlinestore.services.impl;

import com.example.onlinestore.dao.Impl.DefaultProductDao;
import com.example.onlinestore.entities.impl.DefaultPrice;
import com.example.onlinestore.entities.impl.DefaultProduct;
import com.example.onlinestore.entities.script.Price;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.entities.script.enums.Category;
import com.example.onlinestore.entities.script.enums.SubCategory;
import com.example.onlinestore.services.ProductManagementService;

import java.sql.SQLException;
import java.util.List;

public class DefaultProductManagementService implements ProductManagementService {
    DefaultProductDao productDao;
    int qty;

    {
        productDao=new DefaultProductDao();
    }

    @Override
    public void init() {
        createProduct(1,"ricotta pancakes with strawberries",new DefaultPrice(15.99),"Lorem ipsum dolsimus."
                ,"ProductImages/product-1.jpg",Category.FOOD,SubCategory.BAKERY);
        createProduct(2,"Ricotta Pancakes with blue berries and Sweet Lemon Butter",new DefaultPrice(18.99),
                "Lorem ipsum d.",
                "ProductImages/product-2.jpg",Category.FOOD,SubCategory.BAKERY);
        createProduct(3,"Bread and Honey",new DefaultPrice(11.99),"Lorem ipsum dolor s","ProductImages/product-3.jpg",Category.FOOD,
                SubCategory.BAKERY);

    }
    private void createProduct(int id, String productName, Price price, String productDescription,String productLocation, Category category,SubCategory subCategory){
        Product product=new DefaultProduct(id,productName,price,productDescription,
                productLocation,category,subCategory);
        try {
            productDao.addProductsToDb(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Product> getProductByCategory(Category category) {
        try {
            return productDao.retrieveProductByCategory(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductBySubCategory(SubCategory category) {
        try {
            return productDao.retrieveProductBySubCategory(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getProductByProductId(int id) {
        try {
            return productDao.retrieveProductById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
