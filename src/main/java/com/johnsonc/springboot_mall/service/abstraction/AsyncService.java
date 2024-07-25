package com.johnsonc.springboot_mall.service.abstraction;

import org.springframework.scheduling.annotation.Async;

import java.security.NoSuchAlgorithmException;

public interface AsyncService {
    public void assign(String meetingKey) throws InterruptedException, NoSuchAlgorithmException;
}
