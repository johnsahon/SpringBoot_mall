package com.johnsonc.springboot_mall.service.impl;

import com.johnsonc.springboot_mall.service.abstraction.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    /***
     *  @Async 方法不能是私有的。
     *  @Async 方法不能調用同一 Bean 中的其他 @Async 方法（需要將其放在不同的 Bean 中）。
     * HttpServletRequest 不能用
     * @param meetingKey
     * @throws InterruptedException
     * @throws NoSuchAlgorithmException
     */
    @Async("executor")
    public void assign(String meetingKey) throws InterruptedException, NoSuchAlgorithmException {
        // do something...
        // 模擬耗時操作，例如計算或調用外部服務
        log.info("Start processing meetingKey: {}", meetingKey);

        // 模擬長時間運行的操作
        Thread.sleep(5000); // 模擬延遲

        // 假設這裡有一些業務邏輯，例如計算、調用外部 API 等
        String result = performSomeBusinessLogic(meetingKey);

        log.info("Finished processing meetingKey: {}. Result: {}", meetingKey, result);
    }
    private String performSomeBusinessLogic(String meetingKey) {
        // 模擬業務邏輯處理
        return "Processed " + meetingKey;
    }

}
