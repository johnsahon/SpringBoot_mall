package com.johnsonc.springboot_mall.controller;


import com.johnsonc.springboot_mall.dao.GoodsJPARepository;
import com.johnsonc.springboot_mall.dto.rs.GoodsRs;
import com.johnsonc.springboot_mall.model.Goods;
import com.johnsonc.springboot_mall.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Api(tags = "") swaggerUI 用
@RequestMapping("goods")
@RestController
@RequiredArgsConstructor
public class GoodsController {
    private  final  GoodsJPARepository goodsJPARepository;
    @PostMapping(value = "queryGoods")
    public ResponseEntity<List<GoodsRs>> queryGoods(){
        var name = "John";
        var nameListByJohn = goodsJPARepository.findALlByName(name);

        var nameListInput = List.of("John","Marry");
        var nameListByInput = goodsJPARepository.findAllByNameIn(nameListInput);
        var rsList = nameListByInput.stream()
                     .map(x->{
                         var rs = new GoodsRs();
                         BeanUtils.copyProperties(x, rs);
                         return rs;
                     })
                     .collect(Collectors.toList());
        return ResponseEntity.ok(rsList);
    }
}
