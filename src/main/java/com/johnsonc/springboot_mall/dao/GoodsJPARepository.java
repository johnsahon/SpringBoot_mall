package com.johnsonc.springboot_mall.dao;

import com.johnsonc.springboot_mall.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GoodsJPARepository  extends JpaRepository<Goods, Long> {

    Goods findByName(String name);
    List<Goods> findALlByName(String name);

    List<Goods> findAllByNameIn(List<String> names);

}
