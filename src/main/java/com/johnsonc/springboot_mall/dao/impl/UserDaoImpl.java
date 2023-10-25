package com.johnsonc.springboot_mall.dao.impl;


import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.dao.ProductDao;
import com.johnsonc.springboot_mall.dao.UserDao;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.dto.rq.RegisterRquest;
import com.johnsonc.springboot_mall.model.Product;
import com.johnsonc.springboot_mall.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public int createAccount(RegisterRquest rq) {
        //SQL insert into user table
        return 0;
    }

    @Override
    public User getAccountById(RegisterRquest rq){
        // SQL select user_id from user table
        return new User();
    }



}
