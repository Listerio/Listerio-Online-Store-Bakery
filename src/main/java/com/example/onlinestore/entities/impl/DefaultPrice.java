package com.example.onlinestore.entities.impl;

import com.example.onlinestore.entities.script.Price;

public class DefaultPrice implements Price {
   private double price;

    public DefaultPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }
}
