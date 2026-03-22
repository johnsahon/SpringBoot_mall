package com.johnsonc.springboot_mall.service.impl;

import com.johnsonc.springboot_mall.dao.GoodsJPARepository;
import com.johnsonc.springboot_mall.dto.rs.GoodsRs;
import com.johnsonc.springboot_mall.model.Goods;
import com.johnsonc.springboot_mall.service.abstraction.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsJPARepository goodsJPARepository;

    @Override
    public List<GoodsRs> getAllGoods() {
        List<Goods> goods = goodsJPARepository.findAll();
        return goods.stream()
                .map(this::convertToRs)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GoodsRs> getGoodsById(Long id) {
        Optional<Goods> goods = goodsJPARepository.findById(id);
        return goods.map(this::convertToRs);
    }

    @Override
    public List<GoodsRs> searchGoodsByName(String name) {
        List<Goods> goods = goodsJPARepository.findALlByName(name);
        return goods.stream()
                .map(this::convertToRs)
                .collect(Collectors.toList());
    }

    @Override
    public List<GoodsRs> batchSearchGoods(List<String> names) {
        List<Goods> goods = goodsJPARepository.findAllByNameIn(names);
        return goods.stream()
                .map(this::convertToRs)
                .collect(Collectors.toList());
    }

    @Override
    public GoodsRs createGoods(Goods goods) {
        Goods savedGoods = goodsJPARepository.save(goods);
        return convertToRs(savedGoods);
    }

    @Override
    public Optional<GoodsRs> updateGoods(Long id, Goods goods) {
        if (goodsJPARepository.existsById(id)) {
            goods.setId(id);
            Goods updatedGoods = goodsJPARepository.save(goods);
            return Optional.of(convertToRs(updatedGoods));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteGoods(Long id) {
        if (goodsJPARepository.existsById(id)) {
            goodsJPARepository.deleteById(id);
            return true;
        }
        return false;
    }

    private GoodsRs convertToRs(Goods goods) {
        GoodsRs rs = new GoodsRs();
        BeanUtils.copyProperties(goods, rs);
        return rs;
    }
}
