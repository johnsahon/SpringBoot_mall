package com.johnsonc.springboot_mall.service;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.dto.rq.RegisterRquest;
import com.johnsonc.springboot_mall.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public int createAccount(RegisterRquest rq);

}
