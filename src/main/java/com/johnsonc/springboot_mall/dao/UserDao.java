package com.johnsonc.springboot_mall.dao;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.dto.rq.RegisterRquest;
import com.johnsonc.springboot_mall.model.Product;
import com.johnsonc.springboot_mall.model.User;

import java.util.List;

public interface UserDao {

    public int createAccount(RegisterRquest rq);


    public User getAccountById(RegisterRquest rq);

}
