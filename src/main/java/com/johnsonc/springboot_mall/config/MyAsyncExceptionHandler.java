package com.johnsonc.springboot_mall.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("異步任務執行時發生未捕獲的異常: {}", ex.getMessage(), ex);
        log.error("異常發生於方法: {}", method.getName());
        for (Object param : params) {
            log.error("參數值: {}", param);
        }
    }
}