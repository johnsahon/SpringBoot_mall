package com.johnsonc.springboot_mall.service;

import com.johnsonc.springboot_mall.dao.ProductDao;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest rq){
        return productDao.createProduct(rq);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest rq) {
        productDao.updateProduct(productId, rq);
    }
}
