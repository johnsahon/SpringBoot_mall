package com.johnsonc.springboot_mall.dao.impl;


import com.johnsonc.springboot_mall.dao.ProductDao;
import com.johnsonc.springboot_mall.dto.rq.ProductRequest;
import com.johnsonc.springboot_mall.model.Product;
import com.johnsonc.springboot_mall.rowmappmer.ProductRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.*;

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

        if (!productList.isEmpty()){
            return productList.get(0);
        }else{
            System.out.println("get null");
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest rq){
        System.out.println("starting createProductDAO");
        String sql = "INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) " +
                "VALUES (:product_name, :category, :image_url, :price, :stock, :description, :created_date, :last_modified_date)";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("product_name", rq.getProduct_name());
        paramMap.put("category", rq.getCategory().toString());//Category 拿出來是 ProductCategory的類型，要轉成string
        paramMap.put("image_url", rq.getImage_url());
        paramMap.put("price", rq.getPrice());
        paramMap.put("stock", rq.getStock());
        paramMap.put("description", rq.getDescription());
        paramMap.put("created_date", new Date());
        paramMap.put("last_modified_date", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        //return 新增資料的id
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest rq) {
        System.out.println("starting updateProductDAO");
        String sql = "UPDATE product SET " +
                "product_name = :product_name, " +
                "category = :category, " +
                "image_url = :image_url, " +
                "price = :price, " +
                "stock = :stock, " +
                "description = :description, " +
                "last_modified_date = :last_modified_date " +
                "WHERE product_id = :product_id"; // 假設product_id是更新的條件，請根據你的需求調整

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("product_id",productId);

        paramMap.put("product_name", rq.getProduct_name());
        paramMap.put("category", rq.getCategory().toString());
        paramMap.put("image_url", rq.getImage_url());
        paramMap.put("price", rq.getPrice());
        paramMap.put("stock", rq.getStock());
        paramMap.put("description", rq.getDescription());
        paramMap.put("last_modified_date", new Date());
        log.info(paramMap.toString());
        namedParameterJdbcTemplate.update(sql,paramMap);

    }
}
