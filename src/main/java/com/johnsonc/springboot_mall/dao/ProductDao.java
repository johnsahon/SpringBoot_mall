package com.johnsonc.springboot_mall.dao;

import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;

public interface ProductDao {

    public Product getProductById(Integer id);


    public Integer createProduct(ProductRequest rq);
}
