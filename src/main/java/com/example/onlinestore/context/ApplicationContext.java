package com.example.onlinestore.context;

import com.example.onlinestore.entities.script.User;
import com.example.onlinestore.services.Cart;
import com.example.onlinestore.services.impl.DefaultCart;

public class ApplicationContext {
    private Cart sessionCart;
    public static ApplicationContext instance;
    private  User loggedInUser;
    public static final String CLEAR_SESSION_CART_COMMAND="clear";
    public void setLoggedInUser(User user){
        this.loggedInUser=user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setSessionCart(Cart cart){
        sessionCart=cart;
    }

    public static ApplicationContext getInstance() {
        if(instance==null){
            instance=new ApplicationContext();
        }
        return instance;
    }

    public Cart getSessionCart() {
        if(sessionCart==null){
            sessionCart=new DefaultCart();
        }
        return sessionCart;
    }


}
