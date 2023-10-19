package com.johnsonc.springboot_mall.controller;


import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;
import com.johnsonc.springboot_mall.service.ProductService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //http://localhost:8080/products/search/3
    @GetMapping("/search/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){

       Product product = productService.getProductById(productId);

       if(product != null){
           return ResponseEntity.status(HttpStatus.OK).body(product);
       }else{
           log.info("is null");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

/*
    {
        "product_name": "TOYOTA",
        "category": "CAR",
        "image_url": "https://cdn.pixabay.com/photo/2014/02/01/17/28/napple-256261480.jpg",
        "price": 20000,
        "stock": 10,
        "description": ""
    }
        //http://localhost:8080/products/buildProduct
 */
    @PostMapping("/buildProduct/")
    public ResponseEntity<Product> createProduct(@RequestBody @NonNull ProductRequest rq){
        //insert product and return this data
        System.out.println("start buildProduct controller");
        Integer productId = productService.createProduct(rq);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

/*
      {
        "product_name": "TOYOTABB",
        "category": "CAR",
        "image_url": "https://cdn.pixabay.com/photo/2014/02/01/17/28/napple-256261480.jpg",
        "price": 20000,
        "stock": 10,
        "description": ""
    }
//        http://localhost:8080/products/updateProduct/3
 */
    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @NonNull ProductRequest rq){
        //update product and return this data
        log.info("start updateProduct controller");
        productService.updateProduct(productId, rq);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }
}
