package com.example.onlinestore.entities.impl;

import com.example.onlinestore.entities.script.D_Category;
import com.example.onlinestore.entities.script.enums.Category;
import com.example.onlinestore.entities.script.enums.SubCategory;

public class DefaultCategory implements D_Category {
    Category category;
    SubCategory subCategory;


    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public SubCategory getSubCategory() {
        return subCategory;
    }

    @Override
    public void setCategory(Category category) {
        this.category=category;
    }

    @Override
    public void setSubCategory(SubCategory subCategory) {
        this.subCategory=subCategory;
    }
}
