package com.johnsonc.springboot_mall.controller;

import com.johnsonc.springboot_mall.dto.rs.GoodsRs;
import com.johnsonc.springboot_mall.model.Goods;
import com.johnsonc.springboot_mall.service.abstraction.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping("goods")
@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    // 查詢所有商品
    @GetMapping
    public ResponseEntity<List<GoodsRs>> getAllGoods() {
        List<GoodsRs> goodsRsList = goodsService.getAllGoods();
        return ResponseEntity.ok(goodsRsList);
    }

    // 根據 ID 查詢商品
    @GetMapping("/{id}")
    public ResponseEntity<GoodsRs> getGoodsById(@PathVariable Long id) {
        Optional<GoodsRs> goods = goodsService.getGoodsById(id);
        return goods.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    // 根據名稱查詢商品
    @GetMapping("/search")
    public ResponseEntity<List<GoodsRs>> searchGoodsByName(@RequestParam String name) {
        List<GoodsRs> goodsRsList = goodsService.searchGoodsByName(name);
        return ResponseEntity.ok(goodsRsList);
    }

    // 批量查詢
    @PostMapping("/batch-search")
    public ResponseEntity<List<GoodsRs>> batchSearchGoods(@RequestBody List<String> names) {
        List<GoodsRs> goodsRsList = goodsService.batchSearchGoods(names);
        return ResponseEntity.ok(goodsRsList);
    }

    // 新增商品
    @PostMapping
    public ResponseEntity<GoodsRs> createGoods(@RequestBody Goods goods) {
        GoodsRs createdGoods = goodsService.createGoods(goods);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoods);
    }

    // 更新商品
    @PutMapping("/{id}")
    public ResponseEntity<GoodsRs> updateGoods(@PathVariable Long id, @RequestBody Goods goods) {
        Optional<GoodsRs> updatedGoods = goodsService.updateGoods(id, goods);
        return updatedGoods.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // 刪除商品
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        if (goodsService.deleteGoods(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
