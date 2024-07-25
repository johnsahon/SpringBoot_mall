package com.johnsonc.springboot_mall.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AsyncRq {

    String id;

    String msg;

    String key;
}
