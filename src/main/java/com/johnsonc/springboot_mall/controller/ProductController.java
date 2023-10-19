package com.johnsonc.springboot_mall.controller;


import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;
import com.johnsonc.springboot_mall.service.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){

       Product product = productService.getProductById(productId);

       if(product != null){
           return ResponseEntity.status(HttpStatus.OK).body(product);
       }else{
           System.out.println("is null");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }


/*
    {
        "product_name": "TOYOTA",
        "category": "CAR",
        "image_url": "https://cdn.pixabay.com/photo/2014/02/01/17/28/\r\napple-256261480.jpg",
        "price": 20000,
        "stock": 10,
        "description": ""
    }
 */
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @NonNull ProductRequest rq){
        //insert product and return this inserted data
        System.out.println("start creating product controller");
        Integer productId = productService.createProduct(rq);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
