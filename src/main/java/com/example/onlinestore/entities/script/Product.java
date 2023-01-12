package com.example.onlinestore.entities.script;

import com.example.onlinestore.entities.script.enums.Category;
import com.example.onlinestore.entities.script.enums.SubCategory;

public interface Product {


        String getProductName();
        Price getProductPrice();
        String getProductDescription();
        String getProductImageLocation();
        int getProductId();
        Category getProductCategory();
        SubCategory getProductSubCategory();

        void setProductName(String productNade);
        void setProductPrice(Price productPrice);
        void setProductDescription(String description);
        void setProductImageLocation(String imageLocation);
        void setProductId(int id);
        void setProductCategory(Category category);
        void setProductSubCategory(SubCategory subCategory);




}

