package com.example.onlinestore.entities.impl;

import com.example.onlinestore.entities.script.Price;
import com.example.onlinestore.entities.script.Product;
import com.example.onlinestore.entities.script.enums.Category;
import com.example.onlinestore.entities.script.enums.SubCategory;

public class DefaultProduct implements Product {

     private String productName;
     private Price productPrice;
     private String productDescription;
     private String productImageLocation;
     private int productId;
     private Category productCategory;
     private SubCategory productSubCategory;

    public DefaultProduct(){

    }

    public DefaultProduct( int productId,String productName, Price productPrice, String productDescription, String productImageLocation, Category productCategory, SubCategory productSubCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImageLocation = productImageLocation;
        this.productId = productId;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
    }



    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public Price getProductPrice() {
        return productPrice;
    }

    @Override
    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public String getProductImageLocation() {
        return productImageLocation;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public Category getProductCategory() {
        return productCategory;
    }

    @Override
    public SubCategory getProductSubCategory() {
        return productSubCategory;
    }

    @Override
    public void setProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void setProductPrice(Price productPrice) {
        this.productPrice=productPrice;
    }

    @Override
    public void setProductDescription(String description) {
        this.productDescription=description;
    }

    @Override
    public void setProductImageLocation(String imageLocation) {
        this.productImageLocation=imageLocation;
    }

    @Override
    public void setProductId(int id) {
        this.productId=id;
    }

    @Override
    public void setProductCategory(Category category) {
        this.productCategory=category;
    }

    @Override
    public void setProductSubCategory(SubCategory subCategory) {
        this.productSubCategory=subCategory;
    }

    @Override
    public String toString() {
        return "Product id: "+productId+" Product name: "+productName+" ProductDesc: "+productDescription+ " ProductPrice: "+
                productPrice.getPrice()+ " ProductImageLocation: "+productImageLocation;
    }
}
