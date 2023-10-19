package com.johnsonc.springboot_mall.service;

import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {


    Product getProductById(Integer productId);



    Integer createProduct(ProductRequest rq);
}
