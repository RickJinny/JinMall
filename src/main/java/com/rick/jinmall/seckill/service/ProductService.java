package com.rick.jinmall.seckill.service;

import com.rick.jinmall.seckill.model.ItemKill;

import java.util.List;

public interface ProductService {

    List<ItemKill> getKillProductList();

    ItemKill getProductDetail(Integer id) throws Exception;
}
