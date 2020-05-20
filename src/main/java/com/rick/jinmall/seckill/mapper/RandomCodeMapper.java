package com.rick.jinmall.seckill.mapper;


import com.rick.jinmall.seckill.model.RandomCode;

public interface RandomCodeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RandomCode record);

    int insertSelective(RandomCode record);

    RandomCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RandomCode record);

    int updateByPrimaryKey(RandomCode record);

}