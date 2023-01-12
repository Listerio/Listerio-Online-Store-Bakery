package com.example.onlinestore.entities.impl;

import com.example.onlinestore.context.ApplicationContext;
import com.example.onlinestore.dao.Impl.DefaultUserDao;
import com.example.onlinestore.dao.UserDao;
import com.example.onlinestore.entities.script.Order;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.services.Cart;
import com.example.onlinestore.services.impl.DefaultCart;
import com.example.onlinestore.services.impl.DefaultUserManagementService;
import com.example.onlinestore.services.userManagementService;

import java.util.ArrayList;
import java.util.List;

public class DefaultOrder implements Order {

    Cart cart=new DefaultCart();
    private static final int LENGTH_OF_CARD_DIGITS=16;
    private boolean isValid;
    private String timestamp;
    private List<Product> productList;
    private String email;
    private int customerId;
    private String creditCardNumber;
    private ApplicationContext context;
    private UserDao dao=new DefaultUserDao();

    {
        productList=new ArrayList<>();
        context=ApplicationContext.getInstance();
        getCustomerId();
        cart= context.getSessionCart();
    }


    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean isValid(String userInput) {
        if(!userInput.matches("\\d{"+LENGTH_OF_CARD_DIGITS+"}")) {
            return false;
        }
        return true;
    }



    @Override
    public void setCreditCardNumber(String userInput) {
        if(isValid(userInput)){
            creditCardNumber=userInput;
        }
        else {
            System.out.println("Wrong input");
            return;
        }
    }

    @Override
    public void setProducts(List<Product>productList) {
        this.productList=productList;
    }


    public String getCustomerEmail(){
    return this.email=getUser().getEmail();
    }

    @Override
    public User getUser() {
        return context.getLoggedInUser();
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public int getCustomerId() {
         this.customerId=getUser().getUserId();
         return this.customerId;
    }

       @Override
    public void setTimeStamp(String stamp) {
        this.timestamp=stamp;
    }

    @Override
    public String getTimeStamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Order: customer id - " + this.customerId + "\t" +
                "credit card number - " + this.creditCardNumber + "\n" +
                "products - " + productList+"\n";
    }

}
