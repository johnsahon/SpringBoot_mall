package com.johnsonc.springboot_mall.dto.rs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsRs {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
