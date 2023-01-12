package com.example.onlinestore.services;

import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.entities.script.enums.Category;
import com.example.onlinestore.entities.script.enums.SubCategory;

import java.util.List;

public interface ProductManagementService {


    void init();
    List<Product> getProductByCategory(Category category);
    List<Product> getProductBySubCategory(SubCategory category);
    Product getProductByProductId(int id);



}
