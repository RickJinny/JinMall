package com.rick.jinmall.seckill.mapper;

import com.rick.jinmall.seckill.model.Item;

public interface ItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}