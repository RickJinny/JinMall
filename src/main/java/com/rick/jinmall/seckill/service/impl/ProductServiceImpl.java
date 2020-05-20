package com.rick.jinmall.seckill.service.impl;

import com.rick.jinmall.seckill.mapper.ItemKillMapper;
import com.rick.jinmall.seckill.model.ItemKill;
import com.rick.jinmall.seckill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Override
    public List<ItemKill> getKillProductList() {
        List<ItemKill> itemKills = itemKillMapper.selectAll();
        return itemKills;
    }

    @Override
    public ItemKill getProductDetail(Integer id) throws Exception {
        ItemKill entity = itemKillMapper.selectById(id);
        if (entity == null) {
            throw new Exception("获取秒杀详情-待秒杀商品记录不存在");
        }
        return entity;
    }
}
