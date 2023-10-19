package com.johnsonc.springboot_mall.rowmappmer;


import com.johnsonc.springboot_mall.constant.ProductCategory;
import com.johnsonc.springboot_mall.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@Component
public class ProductRowMapper  implements RowMapper<Product> {


    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProduct_id(resultSet.getInt("product_id"));
        product.setProduct_name(resultSet.getString("product_name"));
        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));
        product.setImage_url(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreated_date(new Date(resultSet.getTimestamp("created_date").getTime()));
        product.setLast_modified_date(new Date(resultSet.getTimestamp("last_modified_date").getTime()));
        return product;
    }
}
