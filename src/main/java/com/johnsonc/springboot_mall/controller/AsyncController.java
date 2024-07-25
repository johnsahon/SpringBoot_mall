package com.johnsonc.springboot_mall.controller;


import com.johnsonc.springboot_mall.dto.rq.AsyncRq;
import com.johnsonc.springboot_mall.service.abstraction.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;

@Slf4j
//@Api(tags = "") swaggerUI 用
@RequestMapping("async")
@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final  HttpServletRequest httpRequest;
    private final AsyncService asyncService;

    public ResponseEntity<Map<String, String>> callin(@RequestBody AsyncRq rq) throws NoSuchAlgorithmException, InterruptedException {
        String  tokenData = (String) httpRequest.getAttribute("");
        // 執行非同步任務
        asyncService.assign(rq.getKey());

//        return ResponseEntity.ok(null);
        return ResponseEntity.ok(Collections.singletonMap("status", "started"));
    }





}
