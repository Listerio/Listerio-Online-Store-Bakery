package com.example.onlinestore.services;

import com.example.onlinestore.entities.script.Product;

import java.util.List;
import java.util.Set;

public interface Cart {

    void addToCart(Product productId);
    void removeFromCart(Product productId);
    void clearCart();

    List<Product> getProductList();

}
