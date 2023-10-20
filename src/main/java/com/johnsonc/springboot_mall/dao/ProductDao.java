package com.johnsonc.springboot_mall.dao;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProductList(ProductCategory category, String search);

    public Product getProductById(Integer id);

    public Integer createProduct(ProductRequest rq);

    public void updateProduct(Integer productId, ProductRequest rq);

    public void deleteProductById(Integer productId);


}
