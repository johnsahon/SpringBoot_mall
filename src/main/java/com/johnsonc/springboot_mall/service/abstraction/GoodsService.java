package com.johnsonc.springboot_mall.service.abstraction;

import com.johnsonc.springboot_mall.dto.rs.GoodsRs;
import com.johnsonc.springboot_mall.model.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsService {

    List<GoodsRs> getAllGoods();

    Optional<GoodsRs> getGoodsById(Long id);

    List<GoodsRs> searchGoodsByName(String name);

    List<GoodsRs> batchSearchGoods(List<String> names);

    GoodsRs createGoods(Goods goods);

    Optional<GoodsRs> updateGoods(Long id, Goods goods);

    boolean deleteGoods(Long id);
}
