package com.johnsonc.springboot_mall.dto.rq;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NonNull
    private String product_name;

    @NonNull
    private ProductCategory category;

    @NonNull
    private String image_url;

    @NonNull
    private Integer price;

    @NonNull
    private Integer stock;

    private String description;

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



}
