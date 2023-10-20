package com.johnsonc.springboot_mall.service;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getProductList(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest rq);

    void updateProduct(Integer productId, ProductRequest rq);

    void deleteProductById(Integer productId);


}
