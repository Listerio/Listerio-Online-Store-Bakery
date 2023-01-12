package com.example.onlinestore.services.impl;

import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.services.Cart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultCart implements Cart {

    private List<Product> productList;
    private Product product;


    {
            productList=new ArrayList<>();
    }

    @Override
    public void addToCart(Product product) {
        productList.add(product);
    }
    @Override
    public void removeFromCart(Product product) {
        productList.removeIf(product1 -> product1.getProductId() == product.getProductId());
    }
    @Override
    public void clearCart() {
        productList.clear();
    }
    @Override
    public List<Product> getProductList() {return productList;}

}
