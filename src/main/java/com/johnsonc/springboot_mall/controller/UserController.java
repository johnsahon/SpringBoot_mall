package com.johnsonc.springboot_mall.controller;

import com.johnsonc.springboot_mall.dto.rq.RegisterRquest;
import com.johnsonc.springboot_mall.model.User;
import com.johnsonc.springboot_mall.service.abstraction.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/products")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createProduct(@RequestBody @NonNull RegisterRquest rq) {
        //insert account and return this data
        Integer productId = userService.createAccount(rq);

        return ResponseEntity.status(HttpStatus.CREATED).body("1");
    }

    @PostMapping("/login")
    public ResponseEntity<String> intoSystem(@RequestBody @NonNull RegisterRquest rq) {
        //select account and return this data
        User productId = userService.getAccountById(rq);

        return ResponseEntity.status(HttpStatus.OK).body("1");
    }

}