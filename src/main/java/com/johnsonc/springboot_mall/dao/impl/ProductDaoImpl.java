package com.johnsonc.springboot_mall.dao.impl;


import com.johnsonc.springboot_mall.dao.ProductDao;
import com.johnsonc.springboot_mall.model.Product;
import com.johnsonc.springboot_mall.rowmappmer.ProductRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Product getProductById(Integer product_id){
        System.out.println("starting getProductById");
        String sql="select product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date from product where product_id= :product_id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("product_id", product_id);


        List<Product> productList = namedParameterJdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(Product.class));


        if (productList.size()> 0){
            return productList.get(0);
        }else{
            System.out.println("get null");
            return null;
        }
    }
}
