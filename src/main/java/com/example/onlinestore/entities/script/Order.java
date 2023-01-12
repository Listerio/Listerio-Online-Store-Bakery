package com.example.onlinestore.entities.script;

import java.util.List;

public interface Order {


    boolean isValid(String in);

    void setCreditCardNumber(String userInput);

    void setProducts(List<Product> products);


    User getUser();
    List<Product> getProducts();


    int getCustomerId();
    void setTimeStamp(String Timestamp);
    String getTimeStamp();
}
