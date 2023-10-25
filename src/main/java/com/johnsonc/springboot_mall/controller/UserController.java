package com.johnsonc.springboot_mall.controller;

import com.johnsonc.springboot_mall.service.ProductService;
import com.johnsonc.springboot_mall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/products")
public class UserController {

    @Autowired
    private UserService userService;


}
