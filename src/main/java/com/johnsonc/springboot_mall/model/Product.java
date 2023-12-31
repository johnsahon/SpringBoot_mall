package com.johnsonc.springboot_mall.model;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import lombok.Getter;

import java.util.Date;



@Getter
public class Product {

    private Integer product_id;
    private String product_name;
    private ProductCategory category;
    private String image_url;
    private Integer price;
    private Integer stock;
    private String description;
    private Date created_date;
    private Date last_modified_date;

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

}
