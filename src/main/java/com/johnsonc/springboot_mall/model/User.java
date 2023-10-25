package com.johnsonc.springboot_mall.model;

import com.johnsonc.springboot_mall.constant.ProductCategory;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class User {
    private Integer user_id;
    private String email;
    private String password;
    private Date created_date;
    private Date last_modified_date;


}
